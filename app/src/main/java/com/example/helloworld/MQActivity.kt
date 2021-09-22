package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.rabbitmq.client.*
import java.io.IOException

import java.lang.Exception
import java.nio.charset.Charset
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class MQActivity : AppCompatActivity() {
    private val EXCHANGE = "Signal"
    var subscribeThread: Thread? = null
    var factory: ConnectionFactory? = null
    private var mMessage: String? = null
    lateinit var connection: Connection
    lateinit var publishBtn:Button
    lateinit var msgEt:EditText
    lateinit var threadPool:ExecutorService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mqactivity)

        //下面参数这里要根据实际改
        //下面参数这里要根据实际改
        factory = ConnectionFactory()
        factory!!.host = "121.196.56.55"
        factory!!.port = 14500
        factory!!.username = "guest"
        factory!!.password = "guest"
        factory!!.virtualHost = "/"
        //用于从线程中获取数据，更新ui 把消息根据来的时间写到界面上 测试效果更佳明显 可要可不要
        //用于从线程中获取数据，更新ui 把消息根据来的时间写到界面上 测试效果更佳明显 可要可不要
        val incomingMessageHandler= object :Handler(){
            override fun handleMessage(msg: Message) {
                val message= msg.getData().getString("msg")
                val tv = findViewById<View>(R.id.tv_msg) as TextView
                val now = Date()
                val ft = SimpleDateFormat("HH:mm:ss")
                tv.append(ft.format(now) + ' ' + message + '\n')
                Log.i("test", "msg:$message")
            }


        }
        //开启消费者线程
        //开启消费者线程
        threadPool = Executors.newFixedThreadPool(2)
        subscribe(incomingMessageHandler)
        publishBtn = findViewById(R.id.btn_publish)
        msgEt= findViewById(R.id.et_msg)

        publishBtn.setOnClickListener{
          publish(msgEt.text.toString())
        }

    }

    fun subscribe(handler: Handler) {
        threadPool.execute {
            //                while (true) {
            try {
                //使用之前的设置，建立连接
                connection= factory!!.newConnection()

                //创建一个通道
                val channel: Channel = connection.createChannel()
                //一次只发送一个，处理完成一个再获取下一个
                channel.basicQos(1)
                channel.exchangeDeclare(EXCHANGE, "fanout") //这里要根据实际改
                val mQueue: String = channel.queueDeclare().getQueue()
                channel.queueBind(mQueue, EXCHANGE, "") //这里要根据实际改

                //创建消费者
//                        QueueingConsumer consumer = new QueueingConsumer(channel);
//                        channel.basicConsume(mQueue, true, consumer);
//
//                        while (true) {
//                            Log.i("我是创建的对象", "1");
//                            //wait for the next message delivery and return it.
//                            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//                            String message = new String(delivery.getBody());
//
//                            Log.d("", "[r] " + message);
//
//                            //从message池中获取msg对象更高效
//                            Message msg = handler.obtainMessage();
//                            Bundle bundle = new Bundle();
//                            bundle.putString("msg", message);
//                            msg.setData(bundle);
//                            handler.sendMessage(msg);
//                        }

//                    } catch (InterruptedException e) {
//                        Log.i("我是创建的对象", "1");
//                        break;
                val consumer: Consumer = object : DefaultConsumer(channel) {
                    @Throws(IOException::class)
                    override fun handleDelivery(
                        consumerTag: String, envelope: Envelope,
                        properties: AMQP.BasicProperties, body: ByteArray
                    ) {
                        mMessage = String(body, Charset.forName("UTF-8"))
                        println(" [x] Received '" + envelope.routingKey + "':'" + mMessage + "'")
                        //                                从message池中获取msg对象更高效
                        val msg: Message = handler.obtainMessage()
                        val bundle = Bundle()
                        bundle.putString("msg", mMessage)
                        msg.setData(bundle)
                        handler.sendMessage(msg)
                    }
                }
                channel.basicConsume(mQueue, true, consumer)
                //
            } catch (e1: Exception) {
                Log.d("", "Connection broken: " + e1.javaClass.name)
                if(connection!=null){
                    connection.close()
                }
                try {
                    Thread.sleep(2000) //sleep and then try again
                } catch (e: InterruptedException) {
//                            break;
                }
            }
            Log.i("1111111111111111111111", "run: ")
            //                }
        }
    }

    fun publish(msg:String){
        threadPool.execute {
            if (msg == null || msg.trim().isEmpty()) {
                Looper.prepare()
                Toast.makeText(this, "请输入发送内容", Toast.LENGTH_SHORT).show()
                return@execute
            }
            if (connection == null) {
                connection = factory!!.newConnection()
            }
            val channel = connection.createChannel()
            channel.basicPublish(EXCHANGE, "", null, msg.toByteArray(Charset.forName("UTF-8")))
            channel.close()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}