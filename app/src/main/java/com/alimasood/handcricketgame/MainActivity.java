package com.alimasood.handcricketgame;
import static java.lang.Thread.sleep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class MainActivity extends AppCompatActivity  {
     InterstitialAd mInterstitialAd,mInterstitialAd1;


    SharedPreferences prefs;





    String scores="",scripturlvar,compturns,userturns,target3,itemName,playername=" ",name,url;
    boolean visible=true;
    boolean rvisible=true;
    Button b1,b2,b3,b4,b5,b6,load,nextmatch,exitgame,start,fetch,exitalways;
    LinearLayout happy;


    int playerscoreint=0,wicket=0;
    Random compturn0=new Random();

    int compturn,individual;
    int userturn;
    int target2;


    TextView aftermatch,hint,l,targettext,playerturnscore,compturnscore,playerscore,individualplayerscore,scorecard,border1,editTextTextPersonName,textView4,textView8;
    EditText matchno;
    EditText  scripturl;
    ListView listView;
    ListAdapter adapter;
    String matchnoint,individuals;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            matchno=findViewById(R.id.matchno);
            scripturl=findViewById(R.id.scripturl);
            matchnoint = extras.getString("matchnoint");
             url = extras.getString("url");


            scripturl.setText(url);
            matchno.setText(matchnoint);
            start=findViewById(R.id.start);

            hint=findViewById(R.id.hint);
            load=findViewById(R.id.load);
            load.setVisibility(View.INVISIBLE);
            matchno.setVisibility(View.INVISIBLE);
            hint.setVisibility(View.INVISIBLE);
            scripturl.setVisibility(View.INVISIBLE);









            //The key argument here must match that used in the other activity
        }


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd.load(this,"ca-app-pub-9102423097712233/6010816212", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                       super.onAdLoaded(interstitialAd);
                        mInterstitialAd = interstitialAd;

                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdClicked() {
                                // Called when a click is recorded for an ad.

                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();


                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                              super.onAdFailedToShowFullScreenContent(adError);


                            }

                            @Override
                            public void onAdImpression() {
                             super.onAdImpression();

                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                            super.onAdShowedFullScreenContent();


                            }
                        });


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error

                        mInterstitialAd = null;
                    }
                });

        mInterstitialAd1.load(this,"ca-app-pub-9102423097712233/6891818890", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                        super.onAdLoaded(interstitialAd);
                        mInterstitialAd1 = interstitialAd;

                        mInterstitialAd1.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdClicked() {
                                // Called when a click is recorded for an ad.

                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();


                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);


                            }

                            @Override
                            public void onAdImpression() {
                                super.onAdImpression();

                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent();


                            }
                        });


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error

                        mInterstitialAd1 = null;
                    }
                });
        matchno=findViewById(R.id.matchno);
        scripturl=findViewById(R.id.scripturl);







        nextmatch=findViewById(R.id.nextmatch);
        exitgame=findViewById(R.id.exitgame);
        hint=findViewById(R.id.hint);

        prefs= getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
         name = prefs.getString("url", "No name defined");

        load=findViewById(R.id.load);



        scorecard=findViewById(R.id.scorecard);
        textView4=findViewById(R.id.textView4);
        textView8=findViewById(R.id.textView8);
        textView4.setBackgroundColor(Color.CYAN);
        textView8.setBackgroundColor(Color.CYAN);



        editTextTextPersonName=findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName.setBackgroundColor(Color.YELLOW);
        fetch=findViewById(R.id.fetch);
        exitalways=findViewById(R.id.exitalways);



        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);



        Random target=new Random();
        l = findViewById(R.id.check);

        target2=target.nextInt(550-51)+51;



        target3=""+target2+"";


        targettext=findViewById(R.id.targettext);
        playerturnscore=findViewById(R.id.playerturnscore);
        compturnscore=findViewById(R.id.compturnscore);
        playerscore=findViewById(R.id.playerscore);
        individualplayerscore=findViewById(R.id.individualplayerscore);



        start=findViewById(R.id.start);


        playerscore.setBackgroundColor(Color.YELLOW);
        playerturnscore.setBackgroundColor(Color.CYAN);
        compturnscore.setBackgroundColor(Color.CYAN);
       l.setBackgroundColor(Color.rgb(144,238,144));
        scorecard.setBackgroundColor(Color.rgb(144,238,144));
        aftermatch=findViewById(R.id.aftermatch);















    }
    public void loadurl(View v)
    {



        scripturl.setText(name);
    }


    public void start(View v)
    {
        fetch.setVisibility(View.VISIBLE);
        start.setVisibility(View.INVISIBLE);
         prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        String name = prefs.getString("url", "Not found in memory");

        scripturlvar=scripturl.getText().toString();
        if(scripturlvar.equals("https://script.google.com/macros/s/AKfycbyqJW-8KZrJF421WEayaIMrZ4wpdExWP0J6J99yEvLIg60JRzHrdYCOETAONvVwSsyByg/exec"))
        {

        }
        else
        {


        SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();

        editor.putString("url", scripturlvar);

        editor.commit();}

        l.setVisibility(View.VISIBLE);
        targettext.setVisibility(View.VISIBLE);
        playerturnscore.setVisibility(View.VISIBLE);

        compturnscore.setVisibility(View.VISIBLE);
        playerscore.setVisibility(View.VISIBLE);
        individualplayerscore.setVisibility(View.VISIBLE);
        individualplayerscore.setText("");
        scorecard.setVisibility(View.VISIBLE);
        textView4.setVisibility(View.VISIBLE);
        textView8.setVisibility(View.VISIBLE);
        editTextTextPersonName.setVisibility(View.VISIBLE);
        hint.setVisibility(View.INVISIBLE);
        load.setVisibility(View.INVISIBLE);
        scripturl.setVisibility(View.INVISIBLE);



        targettext.setText(target3);
        matchnoint=matchno.getText().toString();
        getItems();








    }


    public void fetchnames(View v)
    {
        getItems();
    }

    public void getItems()
    {

        StringRequest stringRequestg = new StringRequest(Request.Method.GET,
                scripturlvar,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String responseg) {

                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                            b4.setVisibility(View.VISIBLE);
                            b5.setVisibility(View.VISIBLE);
                            b6.setVisibility(View.VISIBLE);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }






                        parseItems(responseg);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        b1.setVisibility(View.INVISIBLE);
                        b2.setVisibility(View.INVISIBLE);
                        b3.setVisibility(View.INVISIBLE);
                        b4.setVisibility(View.INVISIBLE);
                        b5.setVisibility(View.INVISIBLE);
                        b6.setVisibility(View.INVISIBLE);


                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        Toast.makeText(MainActivity.this,"INTERNET CONNECTION ISSUE",Toast.LENGTH_LONG).show();

                        getItems();




                    }
                }


        );

        int socketTimeOut = 50000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequestg.setRetryPolicy(policy);

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequestg);

    }



    private void parseItems(String jsonResposnce) {

        ArrayList<HashMap<String, String>> list = new ArrayList<>();

        try {
            JSONObject jobj = new JSONObject(jsonResposnce);
            JSONArray jarray = jobj.getJSONArray("items");
            JSONObject jo = jarray.getJSONObject(1);
            String name1=jo.toString();
            String name="\t\t";
            String card="";
            char [] ch=new char[20];
            ch=name1.toCharArray();
            for(int i=0;i<ch.length;i++)
            {
                if(ch[i]==',') {
                    name += "\n";
                    name+="\t\t";

                }
                else if(ch[i]=='[' || ch[i]==']' || ch[i]=='"' || ch[i] ==':' ||ch[i]=='{' || ch[i]=='}')
                    name+="";
                else
                    name+=ch[i];


            }





            l.setText(name);
            



        } catch (JSONException e) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            getItems();

        }


//        adapter = new SimpleAdapter(this,list,R.layout.activity_main,
//                new String[]{"itemName"},new int[]{R.id.check});
//
//
//        listView.setAdapter(adapter);

    }




            public void   add(String a,String b,String c,String d,String e) {






        StringRequest stringRequest = new StringRequest(Request.Method.POST, scripturlvar,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(visible==false) {
                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                            b4.setVisibility(View.VISIBLE);
                            b5.setVisibility(View.VISIBLE);
                            b6.setVisibility(View.VISIBLE);
                            visible = true;
                        }










                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(visible==true){

                       b1.setVisibility(View.INVISIBLE);
                        b2.setVisibility(View.INVISIBLE);
                        b3.setVisibility(View.INVISIBLE);
                        b4.setVisibility(View.INVISIBLE);
                        b5.setVisibility(View.INVISIBLE);
                        b6.setVisibility(View.INVISIBLE);
                        visible=false;}
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }


                        add(matchnoint,individuals,""+wicket+"",""+playerscoreint+"",target3);
                        Toast.makeText(MainActivity.this,"INTERNET CONNECTION ISSUE",Toast.LENGTH_LONG).show();


                    }

                }
        ) {

            @Override
            protected Map<String, String> getParams() {
                // Toast.makeText(AddItem.this,"grape",Toast.LENGTH_LONG).show();
                Map<String, String> parmas = new HashMap<>();

                //here we pass params
                parmas.put("action","addtarget");
                parmas.put("match",a);
                parmas.put("individual",b);
                parmas.put("wicket",c);
                parmas.put("teamscore",d);
                parmas.put("target",e);





                //Toast.makeText(AddItem.this,"grape",Toast.LENGTH_LONG).show();


                return parmas;
            }
        };

        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);






    }

    public void nextmatchf(View v){
//    {hint.setVisibility(View.VISIBLE);
//        load.setVisibility(View.VISIBLE);
//        scripturl.setVisibility(View.VISIBLE);
//        start.setVisibility(View.VISIBLE);
//        matchno.setVisibility(View.VISIBLE);
//        targettext.setVisibility(View.VISIBLE);
//        nextmatch.setVisibility(View.INVISIBLE);
//        exitgame.setVisibility(View.INVISIBLE);
//       aftermatch.setVisibility(View.INVISIBLE);
//       matchno.setText("");
//       targettext.setText("");
//       l.setText("");
//        scorecard.setText("");
//        playerscore.setText("");
//        playerturnscore.setText("");
//        compturnscore.setText("");
//        scripturl.setText("");
//        individual=0;
//        playerscoreint=0;
//        scores="";
//        wicket=0;
//         compturn=0;
//         individual=0;
//        userturn=0;
//        target2=0;
//        Random target=new Random();
//        target2=target.nextInt(550-51)+51;
//        //target2=70;
//
//        target3=""+target2+"";

finish();
Intent s=new Intent(this,intro.class);
s.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
this.startActivity(s);




    }

    public void exitgamef(View v)
    {
        finish();
    }







    public void playerturn(View v) {



        compturn=compturn0.nextInt(7-1)+1;


        compturns=""+compturn+"";
        userturns=""+v.getTag()+"";
        userturn= Integer.parseInt(userturns);
        playerturnscore.setText(userturns);
        compturnscore.setText(compturns);
        if(userturn==compturn)
        {
            individuals= ""+individual+"";

            individualplayerscore.setText(""+individual+"");
            individual=0;
            wicket++;

            if(wicket==5 )
            {
                 new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(mInterstitialAd!=null)
                            mInterstitialAd.show(MainActivity.this);
                        else
                        {

                        }



                    }
                },1000);

            }
            else
            {

            }


            add(matchnoint,individuals,""+wicket+"",""+playerscoreint+"",target3);
            playerscore.setText(""+playerscoreint+" - "+wicket+"");
            scores+=individuals+"\n";
            scorecard.setText(scores);


        }
        else{
            individual+=userturn;
            individualplayerscore.setText(""+individual+"");
            playerscoreint+=userturn;
            playerscore.setText(""+playerscoreint+" - "+wicket+"");

        }

        if(playerscoreint>=target2 || wicket==10)
        {

if(playerscoreint>=target2){}
else
            wicket++;
            add(matchnoint,""+individual+"",""+wicket+"",""+playerscoreint+"",target3);

            l.setVisibility(View.INVISIBLE);
            targettext.setVisibility(View.INVISIBLE);
            playerturnscore.setVisibility(View.INVISIBLE);

            compturnscore.setVisibility(View.INVISIBLE);
            playerscore.setVisibility(View.INVISIBLE);
            individualplayerscore.setVisibility(View.INVISIBLE);
            scorecard.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.INVISIBLE);
            textView8.setVisibility(View.INVISIBLE);
            editTextTextPersonName.setVisibility(View.INVISIBLE);
            hint.setVisibility(View.INVISIBLE);
            load.setVisibility(View.INVISIBLE);
            scripturl.setVisibility(View.INVISIBLE);
            b1.setVisibility(View.INVISIBLE);
            b2.setVisibility(View.INVISIBLE);
            b3.setVisibility(View.INVISIBLE);
            b4.setVisibility(View.INVISIBLE);
            b5.setVisibility(View.INVISIBLE);
            b6.setVisibility(View.INVISIBLE);
            start.setVisibility(View.INVISIBLE);
            matchno.setVisibility(View.INVISIBLE);

            aftermatch.setVisibility(View.VISIBLE);
            nextmatch.setVisibility(View.VISIBLE);
            exitgame.setVisibility(View.VISIBLE);
            fetch.setVisibility(View.INVISIBLE);
            if(playerscoreint>=target2)
                aftermatch.setText("YOU HAVE WON");
            else
                aftermatch.setText("YOU HAVE LOST");
            exitalways.setVisibility(View.INVISIBLE);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(mInterstitialAd1!=null)
                        mInterstitialAd1.show(MainActivity.this);
                    else
                    {

                    }



                }
            },1000);








        }
        else{}


    }

    //This is the part where data is transafeered from Your Android phone to Sheet by using HTTP Rest API calls







}


