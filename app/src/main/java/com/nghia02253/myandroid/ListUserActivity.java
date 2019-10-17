package com.nghia02253.myandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity {
    ListView lvListUser;
    ArrayList<ListUser> arrayListUser;
    ListUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_user);

        anhxa();
        adapter = new ListUserAdapter(this, R.layout.list_user_activity, arrayListUser);
        lvListUser.setAdapter(adapter);

        lvListUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListUserActivity.this, arrayListUser.get(i).getTvStatus(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void anhxa() {
        lvListUser = (ListView) findViewById(R.id.lvListUser);
        arrayListUser = new ArrayList<>();

        arrayListUser.add(new ListUser("07:00, 19/08/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/08/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("08:00, 06/08/2019", "Đã diễn ra", "Hội nghị đánh giá tình hình thực hiện hệ thống chỉ tiêu\nthống kê cấp tỉnh và khảo sát xây dựng phần mềm", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 31/07/2019", "Đã diễn ra", "Hội nghị giao ban tháng 7/2019 với Chủ tịch UBND các \nhuyện, thành phố; Giám đốc một số sở, ngành", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 23/07/2019", "Đã diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 7/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/07/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/06/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("08:00, 06/06/2019", "Đã diễn ra", "Hội nghị đánh giá tình hình thực hiện hệ thống chỉ tiêu\nthống kê cấp tỉnh và khảo sát xây dựng phần mềm", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 31/05/2019", "Đã diễn ra", "Hội nghị giao ban tháng 7/2019 với Chủ tịch UBND các \nhuyện, thành phố; Giám đốc một số sở, ngành", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 23/04/2019", "Đã diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 7/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/08/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/08/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("08:00, 06/08/2019", "Đã diễn ra", "Hội nghị đánh giá tình hình thực hiện hệ thống chỉ tiêu\nthống kê cấp tỉnh và khảo sát xây dựng phần mềm", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 31/07/2019", "Đã diễn ra", "Hội nghị giao ban tháng 7/2019 với Chủ tịch UBND các \nhuyện, thành phố; Giám đốc một số sở, ngành", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 23/07/2019", "Đã diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 7/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/07/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/06/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("08:00, 06/06/2019", "Đã diễn ra", "Hội nghị đánh giá tình hình thực hiện hệ thống chỉ tiêu\nthống kê cấp tỉnh và khảo sát xây dựng phần mềm", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 31/05/2019", "Đã diễn ra", "Hội nghị giao ban tháng 7/2019 với Chủ tịch UBND các \nhuyện, thành phố; Giám đốc một số sở, ngành", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 23/04/2019", "Đã diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 7/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/08/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/08/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("08:00, 06/08/2019", "Đã diễn ra", "Hội nghị đánh giá tình hình thực hiện hệ thống chỉ tiêu\nthống kê cấp tỉnh và khảo sát xây dựng phần mềm", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 31/07/2019", "Đã diễn ra", "Hội nghị giao ban tháng 7/2019 với Chủ tịch UBND các \nhuyện, thành phố; Giám đốc một số sở, ngành", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 23/07/2019", "Đã diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 7/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/07/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/06/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("08:00, 06/06/2019", "Đã diễn ra", "Hội nghị đánh giá tình hình thực hiện hệ thống chỉ tiêu\nthống kê cấp tỉnh và khảo sát xây dựng phần mềm", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 31/05/2019", "Đã diễn ra", "Hội nghị giao ban tháng 7/2019 với Chủ tịch UBND các \nhuyện, thành phố; Giám đốc một số sở, ngành", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 23/04/2019", "Đã diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 7/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/08/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/08/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("08:00, 06/08/2019", "Đã diễn ra", "Hội nghị đánh giá tình hình thực hiện hệ thống chỉ tiêu\nthống kê cấp tỉnh và khảo sát xây dựng phần mềm", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 31/07/2019", "Đã diễn ra", "Hội nghị giao ban tháng 7/2019 với Chủ tịch UBND các \nhuyện, thành phố; Giám đốc một số sở, ngành", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 23/07/2019", "Đã diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 7/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/07/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 19/06/2019", "Sắp diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 8/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("08:00, 06/06/2019", "Đã diễn ra", "Hội nghị đánh giá tình hình thực hiện hệ thống chỉ tiêu\nthống kê cấp tỉnh và khảo sát xây dựng phần mềm", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 31/05/2019", "Đã diễn ra", "Hội nghị giao ban tháng 7/2019 với Chủ tịch UBND các \nhuyện, thành phố; Giám đốc một số sở, ngành", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
        arrayListUser.add(new ListUser("07:00, 23/04/2019", "Đã diễn ra", "Hội nghị UBND tỉnh thường kỳ tháng 7/2019", "Chủ trì: Nguyễn Văn Linh - Chủ tịch UBND tỉnh\nĐịa điểm: Phòng họp số 1, tầng 2, Trụ sở Thường trực HĐND, UBN ", R.drawable.logo));
    }
}
