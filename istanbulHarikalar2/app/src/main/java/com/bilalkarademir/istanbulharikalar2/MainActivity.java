package com.bilalkarademir.istanbulharikalar2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MenuActivity {

    ListView listView;
    List<Model> liste;
    ArrayList<String> mekanListesi;
    ArrayList<String> icerikListesi;
    ArrayList<String> ulasimListesi;
    ArrayList<Bitmap> resimListesi;
    ArrayList<String> konumListesi;

    Context context = this;
    Adapter adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        ListDoldur();
        Listeler();
        tiklama();
    }


    public void Listeler(){

        Bitmap Ayasofya = BitmapFactory.decodeResource(context.getResources(),R.drawable.ayasofya3);
        Bitmap Kizkulesi = BitmapFactory.decodeResource(context.getResources(),R.drawable.kizkulesi3);
        Bitmap Sultanahmetcamisi = BitmapFactory.decodeResource(context.getResources(),R.drawable.sultanahmetcami3);
        Bitmap Topkapisarayi = BitmapFactory.decodeResource(context.getResources(),R.drawable.topkapisarayi3);
        Bitmap Rumelihisari = BitmapFactory.decodeResource(context.getResources(),R.drawable.rumelihisari3);
        Bitmap Yerebatan = BitmapFactory.decodeResource(context.getResources(),R.drawable.yerebatan3);
        Bitmap Gulhane = BitmapFactory.decodeResource(context.getResources(),R.drawable.gulhane3);

        resimListesi.add(Ayasofya);
        resimListesi.add(Gulhane);
        resimListesi.add(Kizkulesi);
        resimListesi.add(Rumelihisari);
        resimListesi.add(Sultanahmetcamisi);
        resimListesi.add(Topkapisarayi);
        resimListesi.add(Yerebatan);

        konumListesi.add("41.008469,28.980261");
        konumListesi.add("41.0127,28.9805 ");
        konumListesi.add("41.128,29.102");
        konumListesi.add("41.0847,29.0561 ");
        konumListesi.add("41.0211,29.0041");
        konumListesi.add("41.013,28.984 ");
        konumListesi.add("41.0081,28.9778 ");




        mekanListesi.add("Ayasofya");
        mekanListesi.add("Gülhane Parkı");
        mekanListesi.add("Kız Kulesi");
        mekanListesi.add("Rumeli Hisarı");
        mekanListesi.add("Sultan Ahmet Camii");
        mekanListesi.add("Topkapı Sarayı");
        mekanListesi.add("Yerebatan Sarnıcı");


        icerikListesi.add("Ayasofya Müzesi’nin yanında konumlanmış olan bu tarihi mekan, çay molası vermek isteyenlerin, pazar günlerinin huzurlu kahvaltıları için alternatif arayanların kesinlikle uğraması gereken bir mekan. 16. yüzyılda Kanuni Sultan Süleyman Dönemi’nde yaptırılan medrese şu an tarihle sanatı da buluşturan bir özelliğe sahip. Medresede cüzi bir ücret karşılığında hat, ebru, takı, resim gibi atölyelere katılabilir, tarihi mekanın keyfini çıkarabilirsiniz.");
        icerikListesi.add("Gülhane Parkı adını, eskiden burada gülbeşeker yapan imalathanelerin yeri olmasından ötürü almıştır. Osmanlı Devleti döneminde Topkapı Sarayı’nın dış bahçesi olarak kullanılmış olan Gülhane Parkı, çok büyük bir alanı kapsamaktadır. Yaklaşık olarak 100.000 m2’lik bir alan bugün hala korunmaktadır. Tarihi yapısından ötürü araştırmalar sonucunda içinde bir sarnıç olduğu tesbit edilmiştir. Bu sarnıç, İstanbul Arkeoloji müzesinin kuzey-batısında Gülhane Parkı içerisindeki Sarayburnuna giden yolun üzerinde olduğu tesbit edilmiştir. ");
        icerikListesi.add("İstanbul Boğazı’nda Salacak açıklarında yer alan küçük bir adacık üzerinde konumlanmış bir kuledir. Hakkında neden yapıldığına dair çeşitli rivayetler ve efsaneler bulunan Kız Kulesi bu gizemi anlayabilmek adına bile görülesi mekanlardandır. Günümüzde eşinizle, dostunuzla gidebileceğiniz, romantik bir akşam yemeği ya da rutin dışında bir öğle molası için gidilebilecek ve yapısıyla mutlaka görülmesi gereken tarihi bir mekandır.");
        icerikListesi.add("Fatih Sultan Mehmet’in, İstanbul’un fethini ne kadar ciddiye aldığının kanıtı niteliğinde Rumeli Hisarı. İkizi ile birlikte yüzlerce yıldır boğazı bir koruyucu edasıyla gözetleyen hisar, zamanla bu görevini terk edip önce bölge halkına barınak, ardından kültürel organizasyonların düzenlendiği bir mekân haline gelmiş.Fatih’in boğazın güvenliğini sağlamak için Anadolu Hisarı’nın tam karşısına yapılmasını emrettiği askeri yapının inşa süreci 15 Nisan 1452’de başlamış. Boğazın en dar noktasına yakın konumdaki 30 dönümlük arazi üzerine inşa edilen yapının ne zaman tamamladığına dair farklı görüşler mevcut.");
        icerikListesi.add("Sultanahmet semti içerisinde bulunan, eski türk filmlerinin unutulmaz mekanları arasında yer alır Soğuk Çeşme Sokağı. Nostaljik haliyle, tarihi yapısıyla İstanbul’un tarihi yerleri içerisinde görülesi mekanların başında gelir. Ayasofya Müzesi ve Topkapı Sarayı arasında yer alan sokak, trafiğe kapalı olma özelliğiyle fotoğraf çekmek ve İstanbul’dan güzel bir hatırayla ayrılmak isteyen turistlerin ilgisini çekmektedir.");
        icerikListesi.add("İhtişamıyla ve mimarisiyle büyüleyen Topkapı Sarayı İstanbul’da görülmeden geçilmemesi gereken tarihi mekanların başında yer alır. 1478 yılında Fatih Sultan Mehmet tarafından yaptırılan saray, 400 yıl boyunca padişahların yaşadığı ve devleti idare ettikleri ana merkez görevini üstlenmiş, tarihe tanıklık etmiştir. Abdülmecit döneminde ziyarete açılan Topkapı Sarayı günümüzde de ziyaretçilerini ağırlamakta, gizemi ve Osmanlı mimarisine ait taşıdığı izlerle ve müzesindeki tarihi eserler ile turistlerin ilgi odağı olmaktadır.");
        icerikListesi.add("İstanbul'un görkemli tarihsel yapılarından birisi de Ayasofya’nın güneybatısında bulunan Bazilika Sarnıcı’dır. Bizans imparatoru I. Justinianus (527-565) tarafından yaptırılan bu büyük yeraltı sarnıcı, suyun içinden yükselen ve sayısız gibigörülen mermer sütunlar sebebiyle halk arasında “Yerebatan Sarayı” olarak isimlendirilmiştir.Sarnıcın bulunduğu yerde daha önce bir Bazilika bulunduğundan, Bazilika Sarnıcı olarak da anılır.");

        ulasimListesi.add("http://www.placesinistanbul.com/istanbulda-nasil-gidilir-iett-tramway-ayasofya.htm?placeID=137&lan=TR");
        ulasimListesi.add("http://www.placesinistanbul.com/istanbulda-nasil-gidilir-iett-tramway-gulhane-parki.htm?placeID=875&lan=TR");
        ulasimListesi.add("http://www.placesinistanbul.com/istanbulda-nasil-gidilir-iett-tramway-kiz-kulesi.htm?placeID=1388&lan=TR");
        ulasimListesi.add("http://www.placesinistanbul.com/istanbulda-nasil-gidilir-iett-tramway-rumeli-hisari.htm?placeID=1395&lan=TR");
        ulasimListesi.add("http://www.placesinistanbul.com/istanbulda-nasil-gidilir-iett-tramway-sultan-ahmet-cami.htm?placeID=139&lan=TR");
        ulasimListesi.add("http://www.placesinistanbul.com/istanbulda-nasil-gidilir-iett-tramway-topkapi-sarayi.htm?placeID=138&lan=TR");
        ulasimListesi.add("http://www.placesinistanbul.com/istanbulda-nasil-gidilir-iett-tramway-yerebatan-sarnici.htm?placeID=136&lan=TR");



    }


    public void tanimla(){

        listView = findViewById(R.id.listView);
        mekanListesi = new ArrayList<>();
        resimListesi = new ArrayList<>();
        konumListesi = new ArrayList<>();
        ulasimListesi = new ArrayList<>();
        liste = new ArrayList<>();
        icerikListesi = new ArrayList<>();
    }


    public void ListDoldur(){

        liste = new ArrayList<>();

        Model m1= new Model("Ayasofya","Bilgi Almak için tıklayınız",R.drawable.ayasofya2);
        Model m2 = new Model("Gülhane Parkı","Bilgi Almak için tıklayınız",R.drawable.gulhane2);
        Model m3 = new Model("Kız Kulesi","Bilgi Almak için tıklayınız",R.drawable.kizkulesi2);
        Model m4 = new Model("Rumeli Hisarı","Bilgi Almak için tıklayınız",R.drawable.rumelihisari2);
        Model m5 = new Model("Sultan Ahmet Camii","Bilgi Almak için tıklayınız",R.drawable.sultanahmetcami2);
        Model m6 = new Model("Topkapı Sarayı","Bilgi Almak için tıklayınız",R.drawable.topkapisayari2);
        Model m7 = new Model("Yerebatan Sarnıcı","Bilgi Almak için tıklayınız",R.drawable.yerebatan2);
        liste.add(m1);
        liste.add(m2);
        liste.add(m3);
        liste.add(m4);
        liste.add(m5);
        liste.add(m6);
        liste.add(m7);
        adp = new Adapter(liste,this);
        listView.setAdapter(adp);




    }

    public void tiklama(){

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,DetayActivity.class);
                intent.putExtra("isim",mekanListesi.get(position));
                intent.putExtra("icerik",icerikListesi.get(position));
                intent.putExtra("ulasim",ulasimListesi.get(position));
                intent.putExtra("konum",konumListesi.get(position));

                Bitmap bitmap = resimListesi.get(position);
                Globals globals = Globals.getInstance();
                globals.setData(bitmap);
                startActivity(intent);

            }
        });
    }


}
