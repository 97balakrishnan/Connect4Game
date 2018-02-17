package com.example.user.connect4;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class single_player_activity extends AppCompatActivity {

    private char[][] place = new char[7][8];
    int[] top = new int[8];
    ImageView[][] img = new ImageView[7][8];
    ImageView[] win=new ImageView[5];
    public Boolean player=true;
    public char playerwon;
    Random rand=new Random();

    void compturn()
    {
        int fl=0,t,k;
        do {
            k = rand.nextInt(7) + 1;
            if (top[k] < 6) {
                 t = ++top[k];
                place[t][k] = 'c';
                updateplace();
                fl = 1;
            }
        }while(fl==0);
    }

    public void draw()
    {
        TextView txt=(TextView)findViewById(R.id.textView2);
        txt.setText("GAME OVER- DRAW!!");

        txt.setBackgroundColor(Color.rgb(255,255,102));

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 2500);
    }


    void winner()
    {
        TextView txt=(TextView)findViewById(R.id.textView2);
        if(playerwon=='c') {
            txt.setText("COMPUTER WON!!!");
            txt.setTextColor(Color.rgb(255,0,127));
        }
        else if(playerwon=='p')
        {
            txt.setText("PLAYER WON!!!");
            txt.setTextColor(Color.rgb(0,0,153));
        }

        txt.setBackgroundColor(Color.rgb(51,255,153));



        for(int i=1;i<=4;i++)
            win[i].setImageResource(R.drawable.greenround);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               finish();
            }
        }, 2500);



    }




    Boolean check() {
        int i,j;
        int cnt = 1;

        //checking draw

        int fl=0;

        for(i=1;i<=6;i++)
        {
            for(j=1;j<=7;j++) {
                if(place[i][j]=='_')
                {
                    fl=1;
                    break;
                }
            }

        }

        if(fl==0)
            draw();

        //checking accross

        for (i = 1; i <= 6; i++)
        {
            cnt = 1;
            for (j = 2; j <= 7; j++)
            {
                if (place[i][j - 1] != '_')
                {
                    if (place[i][j - 1] == place[i][j]){
                        if(cnt==1)
                            win[cnt]=img[i][j-1];
                        cnt++;
                        win[cnt]=img[i][j];
                    }

                    else
                        cnt = 1;
                }
                else
                    cnt = 1;

                if (cnt == 4)
                {

                    playerwon=place[i][j-1];
                    winner();
                    return true;
                }


            }
        }
        cnt = 1;

        //checking downwards

        for (j = 1; j <= 7; j++)
        {
            cnt = 1;
            for (i = 2; i <= 6; i++)
            {
                if (place[i - 1][j] != '_')
                {
                    if (place[i - 1][j] == place[i][j]) {
                        if(cnt==1)
                            win[cnt]=img[i-1][j];
                        cnt++;
                        win[cnt]=img[i][j];


                    } else
                        cnt = 1;
                } else
                    cnt = 1;

                if (cnt == 4) {

                    playerwon=place[i-1][j];
                    winner();
                    return true;
                }

            }
        }

        cnt = 0;


        int x = 2, k;
        char p = 'c';
        //checking diagonals for each player
        while ((x--)!=0)
        {

            cnt = 0;

            for (k = 4; k >= 1; k--) {
                cnt = 0;
                for (i = 1, j = k; j <= 7&&i<=6; i++, j++)
                {
                    if (place[i][j] == p){
                        cnt++;
                        win[cnt]=img[i][j];
                    }

                    else
                        cnt = 0;

                    if (cnt == 4) {

                        playerwon=p;
                        winner();
                        return true;
                    }

                }
            }
            for (k = 4; k <= 7; k++) {
                cnt = 0;
                for (i = 1, j = k; j > 0&&i<=6; i++, j--) {
                    if (place[i][j] == p)
                    {
                        cnt++;
                        win[cnt]=img[i][j];
                    }
                    else
                        cnt = 0;

                    if (cnt == 4) {

                        playerwon=p;
                        winner();

                        return true;
                    }

                }
            }
            p = 'p';

        }

        return false;

    }








    public void updateplace() {


        img[1][1]=(ImageView)findViewById(R.id.iv11);
        img[1][2]=(ImageView)findViewById(R.id.iv12);
        img[1][3]=(ImageView)findViewById(R.id.iv13);
        img[1][4]=(ImageView)findViewById(R.id.iv14);
        img[1][5]=(ImageView)findViewById(R.id.iv15);
        img[1][6]=(ImageView)findViewById(R.id.iv16);
        img[1][7]=(ImageView)findViewById(R.id.iv17);
        img[2][1]=(ImageView)findViewById(R.id.iv21);
        img[2][2]=(ImageView)findViewById(R.id.iv22);
        img[2][3]=(ImageView)findViewById(R.id.iv23);
        img[2][4]=(ImageView)findViewById(R.id.iv24);
        img[2][5]=(ImageView)findViewById(R.id.iv25);
        img[2][6]=(ImageView)findViewById(R.id.iv26);
        img[2][7]=(ImageView)findViewById(R.id.iv27);
        img[3][1]=(ImageView)findViewById(R.id.iv31);
        img[3][2]=(ImageView)findViewById(R.id.iv32);
        img[3][3]=(ImageView)findViewById(R.id.iv33);
        img[3][4]=(ImageView)findViewById(R.id.iv34);
        img[3][5]=(ImageView)findViewById(R.id.iv35);
        img[3][6]=(ImageView)findViewById(R.id.iv36);
        img[3][7]=(ImageView)findViewById(R.id.iv37);
        img[4][1]=(ImageView)findViewById(R.id.iv41);
        img[4][2]=(ImageView)findViewById(R.id.iv42);
        img[4][3]=(ImageView)findViewById(R.id.iv43);
        img[4][4]=(ImageView)findViewById(R.id.iv44);
        img[4][5]=(ImageView)findViewById(R.id.iv45);
        img[4][6]=(ImageView)findViewById(R.id.iv46);
        img[4][7]=(ImageView)findViewById(R.id.iv47);
        img[5][1]=(ImageView)findViewById(R.id.iv51);
        img[5][2]=(ImageView)findViewById(R.id.iv52);
        img[5][3]=(ImageView)findViewById(R.id.iv53);
        img[5][4]=(ImageView)findViewById(R.id.iv54);
        img[5][5]=(ImageView)findViewById(R.id.iv55);
        img[5][6]=(ImageView)findViewById(R.id.iv56);
        img[5][7]=(ImageView)findViewById(R.id.iv57);
        img[6][1]=(ImageView)findViewById(R.id.iv61);
        img[6][2]=(ImageView)findViewById(R.id.iv62);
        img[6][3]=(ImageView)findViewById(R.id.iv63);
        img[6][4]=(ImageView)findViewById(R.id.iv64);
        img[6][5]=(ImageView)findViewById(R.id.iv65);
        img[6][6]=(ImageView)findViewById(R.id.iv66);
        img[6][7]=(ImageView)findViewById(R.id.iv67);




        int i,j;
        String s;
        StringBuilder sb = new StringBuilder();
        for(i=1;i<=6;i++)
            for(j=1;j<=7;j++) {
                sb.append(place[i][j]);
                sb.append(',');
            }   s = sb.toString();


        Log.i("my1243",s);

        for (i = 1; i <= 6; i++)
            for (j = 1; j <= 7; j++) {
                if (place[i][j] == 'p')
                    img[i][j].setImageResource(R.drawable.blueround);
                else if (place[i][j] == '_')
                    img[i][j].setImageResource(R.drawable.blackround);
                else
                    img[i][j].setImageResource(R.drawable.redround);
            }

        check();

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single_player_activity);

        int i,j;
        for(i=1;i<=6;i++)
            for(j=1;j<=7;j++)
                place[i][j]='_';

        for(i=1;i<=7;i++)
            top[i]=0;


        Context context = getApplicationContext();
        CharSequence text = "Hello player! start playing!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
        toast.show();



    }


    public void insert1(View v) {




        int t;

        if(top[1]<6)
        {
            top[1]++;
            t=top[1];
            place[t][1]='p';

            updateplace();
            compturn();



        }

    }
    public void insert2(View v)
    {

        int t;
        if(top[2]<6)
        {
            top[2]++;
            t=top[2];

                place[t][2] = 'p';

            updateplace();
            compturn();

        }
    }
    public void insert3(View v)
    {
        int t=top[3];
        if(top[3]<6)
        {
            t=++top[3];

                place[t][3] = 'p';
            updateplace();
            compturn();


        }
    }
    public void insert4(View v)
    {
        int t;
        if(top[4]<6)
        {
            t=++top[4];
                place[t][4] = 'p';

            updateplace();
            compturn();


        }
    }
    public void insert5(View v)

    {
        int t;
        if(top[5]<6)
        {
            t=++top[5];
                place[t][5] = 'p';

            updateplace();
            compturn();


        }

    }
    public void insert6(View v)
    {
        int t;
        if(top[6]<6)
        {
            t=++top[6];
                place[t][6] = 'p';


            updateplace();
            compturn();



        }
    }
    public void insert7(View v)
    {
        int t;
        if(top[7]<6)
        {
            t=++top[7];
                place[t][7] = 'p';

            updateplace();
            compturn();


        }
    }
}
