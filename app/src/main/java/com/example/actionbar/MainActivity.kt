package com.example.actionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //showAsAction : ActionBar 배치 여부를 결정한다.
    //actionViewClass : 접었다 폈다 할 때 나타날 뷰를 설정한다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        var search_item:MenuItem? = menu?.findItem(R.id.item5) //메뉴 아이템 객체부터 추출(MenuItem의 객체)
        var search_view:SearchView = search_item?.actionView as SearchView

        search_view.queryHint = "검색어를 입력해주세요"

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean { //newText : 입력된 문자열 의미
                textView.text = newText

                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                textView2.text = query
                return false //true로 하면 검색어 입력 후 키보드가 내려가지 않음
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.item1 ->
                textView.text = "메뉴1을 눌렀습니다"
            R.id.item2 ->
                textView.text = "메뉴2을 눌렀습니다"
            R.id.item3 ->
                textView.text = "메뉴3을 눌렀습니다"
            R.id.item4 ->
                textView.text = "메뉴4을 눌렀습니다"
        }
        return super.onOptionsItemSelected(item)
    }
}
