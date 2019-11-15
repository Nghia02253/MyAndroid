package com.nghia02253.myandroid;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity {
    ListView lvListUser;
    ArrayList<ListUser> arrayListUser;
    ListUserAdapter adapter;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_user);

        anhxa();
        arrayListUser = new ArrayList<>();
        adapter = new ListUserAdapter(this, R.layout.list_user_activity, arrayListUser);
        database = new Database(this, "ghichu.sqlite", null, 1);
        //database.QueryData("CREATE TABLE IF NOT EXISTS ListUser(Id INTEGER PRIMARY KEY AUTOINCREMENT, CreatedDate DATE, Status VARCHAR(100), Title VARCHAR(500), Desc TEXT)");

        //database.QueryData("INSERT INTO ListUser VALUES(null, datetime(), 'Sắp diễn ra', 'Hội nghị UBND tỉnh thường kỳ tháng 8/2019', 'Hội nghị UBND tỉnh thường kỳ tháng 8/2019' )");
        //database.QueryData("INSERT INTO ListUser VALUES(null, datetime(), 'Đã diễn ra', 'Hội nghị đánh giá tình hình thực hiện hệ thống chỉ tiêu\nthống kê cấp tỉnh và khảo sát xây dựng phần mềm', 'Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN' )");

        GetDataUser();
        lvListUser.setAdapter(adapter);

        lvListUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListUserActivity.this, arrayListUser.get(i).getTvStatus(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void GetDataUser() {
        Cursor dataListUser = database.GetData("SELECT * FROM ListUser ORDER BY CreatedDate DESC");
        arrayListUser.clear();
        while (dataListUser.moveToNext()) {
            int idUser = dataListUser.getInt(0);
            String Time = dataListUser.getString(1);
            String Status = dataListUser.getString(2);
            String Title = dataListUser.getString(3);
            String Desc = dataListUser.getString(4);

            arrayListUser.add(new ListUser(Time, Status, Title, Desc, R.drawable.logo, idUser));
        }
        adapter.notifyDataSetChanged();
    }
    private void anhxa() {
        lvListUser = (ListView) findViewById(R.id.lvListUser);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_user, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuAddUser) {
            DialogAddUser();
        }
        return super.onOptionsItemSelected(item);
    }

    public void DialogEditUser(String edtStatus, String edtTitle, String edtDesc, int idUser) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_edit_user);
        dialog.show();

        final EditText edtStatusForm, edtTitleForm, edtDescForm;
        Button btnEdit, btnCancel;

        edtStatusForm = dialog.findViewById(R.id.edtStatus);
        edtTitleForm = dialog.findViewById(R.id.edtTitle);
        edtDescForm = dialog.findViewById(R.id.edtDesc);
        btnEdit = dialog.findViewById(R.id.btnUpdateUser);
        btnCancel = dialog.findViewById(R.id.btnDeleteUser);

        edtStatusForm.setText(edtStatus);
        edtTitleForm.setText(edtTitle);
        edtDescForm.setText(edtDesc);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
    private void DialogAddUser() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_user);
        dialog.show();

        final EditText edtStatus, edtTitle, edtDesc;
        Button btnAddUser, btnCancel;

        edtStatus = dialog.findViewById(R.id.edtStatus);
        edtTitle = dialog.findViewById(R.id.edtTitle);
        edtDesc = dialog.findViewById(R.id.edtDesc);
        btnAddUser = dialog.findViewById(R.id.btnAddUser);
        btnCancel = dialog.findViewById(R.id.btnCancel);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Status   = edtStatus.getText().toString().trim();
                String Title    = edtTitle.getText().toString().trim();
                String Desc     = edtDesc.getText().toString().trim();

                if(Status.equals("") && Title.equals("") & Desc.equals("")) {
                    Toast.makeText(ListUserActivity.this, "Vui lòng nhập đầy đủ dữ liệu !", Toast.LENGTH_LONG).show();
                } else {
                    database.QueryData("INSERT INTO ListUser VALUES(null, datetime(), '" + Status + "', '" + Title + "', '" + Desc + "' )");
                    Toast.makeText(ListUserActivity.this, "Success", Toast.LENGTH_LONG).show();
                    dialog.dismiss();

                    GetDataUser();

                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
