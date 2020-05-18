package com.example.fastfood1.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.fastfood1.R;
import com.example.fastfood1.adapter.LoaiSPAdpter;
import com.example.fastfood1.adapter.SanPhamAdapter;
import com.example.fastfood1.model.LoaiSP;
import com.example.fastfood1.model.SanPham;
import com.example.fastfood1.util.CheckConnection;
import com.example.fastfood1.util.Server;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TrangChu extends AppCompatActivity {

    //khai báo các biến để ánh xạ bên layout
    androidx.appcompat.widget.Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewmanhinhchinh;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;

    //khai báo các biến cục bộ
    ArrayList<LoaiSP> mangloaisp; //danh sách loại sản phẩm
    LoaiSPAdpter loaiSPAdpter; //biến adapter của danh sách loại sản phẩm

    //khai báo các biến hỗ trợ cho hàm GetDuLieuLoaiSP()
    int MaLoai = 0;
    String TenLoai="";
    String Hinh="";
    ArrayList<SanPham> mangSP;
    SanPhamAdapter sanPhamAdapter;


    //Hàm khởi tạo trang
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        Anhxa();
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
            GetDuLieuLoaiSP();
            GetDuLieuSP();
            CatchOnItemListView();
        }else{
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
            finish();
        }

    }

    //hàm khởi tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu); //gắn layout cho menu
        return true;
    }

    //hàm xử lý khi đối tượng trên menu được ấn
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                //Đi đến trang giỏ hàng
        }
        return super.onOptionsItemSelected(item);
    }

    private void CatchOnItemListView() {
        listViewmanhinhchinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            //Kết nối mạng được

                            //đi đến trang chủ
                            Intent intent = new Intent(TrangChu.this,TrangChu.class);
                            startActivity(intent);
                        }else{
                            //thông báo nếu kết nối internet không có
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            //Đến trang danh sách thức ăn
                        }else{
                            //thông báo nếu kết nối internet không có
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            //Đến trang danh sách thức uống
                        }else{
                            //thông báo nếu kết nối internet không có
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            //Đến trang danh sách liên hệ
                        }else{
                            //thông báo nếu kết nối internet không có
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            //Đến trang
                        }else{
                            //thông báo nếu kết nối internet không có
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }

    //lấy dữ liệu sản phẩm
    private void GetDuLieuSP() {

    }

    private void GetDuLieuLoaiSP() {

    }

    //Quang cao
    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://sudospaces.com/chanhtuoi-com/uploads/2015/12/12346301_728774220488160_2265584788369422954_n1.jpg");
        mangquangcao.add("https://www.khuyenmaivui.com/wp-content/uploads/2015/04/KFC-khuyen-mai-4.2015-99k-an-cuc-da.png");
        mangquangcao.add("https://khuyenmaiviet.vn/wp-content/uploads/2018/10/44699197_1511763238855917_2680120478160388096_n.jpg");
        mangquangcao.add("https://cdn.phunuvagiadinh.vn/4_1_1_1_1_1.png");
        for(int i=0;i<mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    //Cài đặt cho TooLbar
    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    //anh xạ các đối tượng bên layout với biến đã khai báo
    private void Anhxa(){
        //ánh xạ các đối tượn hiển thị
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewflipper);
        recyclerViewmanhinhchinh = findViewById(R.id.recyclerview);
        navigationView = findViewById(R.id.navigationview);
        listViewmanhinhchinh = findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerlayout);

    }
}
