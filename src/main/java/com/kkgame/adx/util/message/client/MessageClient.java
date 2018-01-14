package com.kkgame.adx.util.message.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kkgame.adx.util.OM;
import com.kkgame.adx.util.StringUtil;
import com.kkgame.adx.util.message.Message;
import com.kkgame.adx.util.message.MessageConsumerCommitReq;
import com.kkgame.adx.util.message.MessagePullReq;
import com.kkgame.adx.util.message.MessagePushReq;
import com.kkgame.adx.util.message.Resp;
import com.kkgame.adx.util.message.RespOne;

/**
 * Created by Administrator on 2017/8/17.
 */
    
public class MessageClient {
    private String apiBase;
    Logger LOG =Logger.getLogger(MessageClient.class);

    /**
     * @param apiBase eg: http://node14:5555
     */
    public MessageClient(String apiBase) {
        this.apiBase = apiBase;
    }

    //拉取
    public Resp<List<Message>> pullMessage(MessagePullReq req){
        return pullMessage(false, req);
    }
    public Resp<List<Message>> pullMessage(boolean fastFail, MessagePullReq req){
        Resp<List<Message>> res = new Resp<List<Message>>();
        if(req.getTopics() == null || StringUtil.isEmpty(req.getConsumer())) return res;

        boolean doCall = true;
        while (doCall) {
            try {
                StringBuffer bf = new StringBuffer();
                for (String t : req.getTopics()) {
                    if (bf.length() > 0) {
                        bf.append("&");
                    }
                    try {
                        bf.append("topics=").append(URLEncoder.encode(t, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }

                String url = apiBase + "/Api/Message?consumer=" + req.getConsumer() + "&" + bf.toString();
                LOG.warn("MessageClient pullMessage rest api request:\n"+ url);

                String resp = callRestApi(url, null, "GET");

                LOG.warn("MessageClient pullMessage rest api response:\n" + resp);

                res = OM.toBean(resp, new TypeReference<Resp<List<Message>>>() {});

                if (res.getStatus() != 1) {
                    throw new RuntimeException(res.getError());
                } else {
                    doCall = false;
                }
            }catch (Exception ex) {
                if(fastFail) {
                    throw new RuntimeException(ex);
                }else {
                    LOG.warn("MessageClient pushMessage error, will try again!! ", ex);
                    try {
                        Thread.sleep(1000*5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return res;
    }

    //推送
    public Resp<List<Message>> pushMessage(MessagePushReq... req){
        return pushMessage(false, req);
    }
    public Resp<List<Message>> pushMessage(boolean fastFail, MessagePushReq... req){
        Resp<List<Message>> res = new Resp<List<Message>>();
        if (req.length == 0) return res;

        boolean doCall = true;
        while (doCall) {
            try {
                StringBuffer bf = new StringBuffer();

                String url = apiBase + "/Api/Message";
                LOG.warn("MessageClient pushMessage rest api request:\n" + "url: " + url + ", \nbody: " + OM.toJOSN(req));

                String resp = callRestApi(url, OM.toJOSN(req), "POST");

                LOG.warn("MessageClient pushMessage rest api response:\n" + resp);

                res = OM.toBean(resp, new TypeReference<Resp<List<Message>>>() {
                });
                if (res.getStatus() != 1) {
                    throw new RuntimeException(res.getError());
                }else {
                    doCall = false;
                }
            }catch (Exception ex) {
                if(fastFail) {
                    throw new RuntimeException(ex);
                }else {
                    LOG.warn("MessageClient pushMessage error, will try again!! ", ex);
                    try {
                        Thread.sleep(1000*5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return res;
    }

    //提交
    public RespOne<String> commitMessageConsumer(MessageConsumerCommitReq... req){
        return commitMessageConsumer(false, req);
    }
    public RespOne<String> commitMessageConsumer(boolean fastFail, MessageConsumerCommitReq... req){
        RespOne<String> res = new RespOne<String>();
        if(req.length == 0) return res;

        boolean doCall = true;
        while (doCall) {
            try {
                StringBuffer bf = new StringBuffer();

                String url = apiBase +"/Api/Message/Consumer";
                LOG.warn("MessageClient commitMessageConsumer rest api request:\n" + "url: " + url + ", \n body: " + OM.toJOSN(req));

                String resp = callRestApi(url, OM.toJOSN(req),"POST");

                LOG.warn("MessageClient commitMessageConsumer rest api response:\n" + resp);

                res = OM.toBean(resp, new TypeReference<RespOne<String>>() {});

                if (res.getStatus() != 1) {
                    throw new RuntimeException(res.getError());
                }else {
                    doCall = false;
                }
            }catch (Exception ex) {
                if(fastFail) {
                    throw new RuntimeException(ex);
                }else {
                    LOG.warn("MessageClient pushMessage error, will try again!! ", ex);
                    try {
                        Thread.sleep(1000*5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MessageClient messageClient = new MessageClient("http://localhost:5555/");
//        Object o = messageClient.pullMessage(new MessagePullReq().setConsumer("consumer1").setTopics(new String[]{"topoc1"}));
//        System.out.println("RES:\n"+ o);

//        messageClient.pushMessage(new MessagePushReq("topic2", "key2", true, "data2"));

        messageClient.pullMessage(new MessagePullReq("consumer2", new String[]{"topic2"}));

        //messageClient.commitMessageConsumer(new MessageConsumerCommitReq("consomer2", "topic2", 1502966622889L));



    }


    private static String callRestApi(String addr, String body, String requestMethod) {
        String result = "";
        try {
            URL url = new URL(addr);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod(requestMethod/*"PUT"*/);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type",
                    "application/json;charset=UTF-8");
            if (body != null) {
                PrintWriter out = new PrintWriter(connection.getOutputStream());
                out.write(body);
                out.close();
            }
            BufferedReader in;
            try {
                in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
            } catch (Exception exception) {
                java.io.InputStream err = ((HttpURLConnection) connection)
                        .getErrorStream();
                if (err == null)
                    throw exception;
                in = new BufferedReader(new InputStreamReader(err));
            }
            StringBuffer response = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null)
                response.append(line + "\n");
            in.close();

            result = response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
