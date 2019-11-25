package com.nghia02253.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class ChatActivity extends AppCompatActivity {

    ListView lvUsers, lvContent;
    EditText edtInputChart;
    Button btnSend, btnAddUser;

    ArrayList<String> arrayList;
    ArrayAdapter adapter;

    ArrayList<String> arrayChat;
    ArrayAdapter adapterChat;

    private Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);

        AnhXa();

        try {
            mSocket = IO.socket("http://192.168.2.132:3000/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        mSocket.connect();

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lvUsers.setAdapter(adapter);

        arrayChat = new ArrayList<>();
        adapterChat = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayChat);
        lvContent.setAdapter(adapterChat);

        mSocket.on("server-request-register", onRetrieveData);
        mSocket.on("server-send-listuser", listUser);
        mSocket.on("server-request-chat", onRetrieveChat);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtInputChart.getText().toString().length() > 0){
                    mSocket.emit("client-register-user", edtInputChart.getText().toString().trim());
                }
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtInputChart.getText().toString().length() > 0){
                    mSocket.emit("client-send-chat", edtInputChart.getText().toString().trim());
                }
            }
        });

    }
    private Emitter.Listener onRetrieveData = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject jsonObject = (JSONObject) args[0];
                    try {
                        boolean ten = jsonObject.getBoolean("noidung");
                        if(ten){
                            Toast.makeText(ChatActivity.this, "User đã tồn tại", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(ChatActivity.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
    private Emitter.Listener onRetrieveChat = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject jsonObjectChat = (JSONObject) args[0];
                    try {
                        String stringChat = jsonObjectChat.getString("chatresult");
                        arrayChat.add(stringChat);
                        adapterChat.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
    private Emitter.Listener listUser = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject jsonObject = (JSONObject) args[0];
                    try {
                        JSONArray jsonArray = jsonObject.getJSONArray("listuser");
                        arrayList.clear();
                        for (int i = 0; i < jsonArray.length(); i++ ){
                            String user = jsonArray.getString(i);
                            arrayList.add(user);
                        }
                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
    private void AnhXa() {
        lvUsers = findViewById(R.id.lvUser);
        lvContent = findViewById(R.id.lvContent);
        edtInputChart = findViewById(R.id.etInputChart);
        btnSend = findViewById(R.id.btnSend);
        btnAddUser = findViewById(R.id.btnAddUser);
    }
}
