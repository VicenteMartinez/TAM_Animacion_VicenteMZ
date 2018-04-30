package mx.edu.ittepic.tam_animacion_vicentemz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.view.View;

/**
 * Created by Maximo on 04/10/2017.
 */

public class Lienzo extends View{
    CountDownTimer timer;
    int r,g,b,x1n1,x2n1,x1n2,x2n2,x1n3,x2n3;
    boolean movimiento;
    public Lienzo(Context context) {

        super(context);
        r=142;
        g=198;
        b=215;
        x1n1=500;
        x2n1=800;
        x1n2=400;
        x2n2=700;
        x1n3=250;
        x2n3= 600;
        movimiento = true;
        timer=new CountDownTimer(10000,50) {
            @Override
            public void onTick(long l) {
                if(movimiento==true) {
                    x1n1+=4;
                    x2n1+=4;
                    x1n2+=4;
                    x2n2+=4;
                    x1n3+=4;
                    x2n3+=4;
                }else{
                    x1n1-=4;
                    x2n1-=4;
                    x1n2-=4;
                    x2n2-=4;
                    x1n3-=4;
                    x2n3-=4;
                }
                if(x2n1>915){
                    if(movimiento==true){
                    r-=2;
                    g-=2;
                    b-=2;}
                    if(movimiento==false){
                        r+=2;
                        g+=2;
                        b+=2;
                    }
                }
                if(x2n1>=1118){
                    movimiento = false;
                }
                if(x2n1<400){
                    movimiento=true;
                }
                invalidate();//vuelve a ejecutar el onDraw

            }

            @Override
            public void onFinish() {

                timer.start();
            }
        };

        timer.start();//Invocar ejecucion en segundo pano
    }
    public void onDraw(Canvas c){
        Paint p=new Paint();

        //fondo
        p.setColor(Color.argb(255,r,g,b));
        RectF fondo = new RectF(0,0, getWidth(), getHeight());
        c.drawRect(fondo, p);
        //sol
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.YELLOW);
        c.drawCircle(1000,100,50,p);
        c.drawLine(945,100,915,100,p);
        c.drawLine(1000,45,1000,15,p);
        c.drawLine(1000,155,1000,185,p);
        c.drawLine(1055,100,1085,100,p);

        c.drawLine(960,45,950,30,p);
        c.drawLine(1040,45,1050,30,p);
        c.drawLine(960,145,950,155,p);
        c.drawLine(1040,145,1049,157,p);
        //nubes
        p.setColor(Color.BLUE);
        RectF nube1 = new RectF(x1n1, 100, x2n1, 200);
        c.drawOval(nube1, p);
        RectF nube2 = new RectF(x1n2, 40, x2n2, 140);
        c.drawOval(nube2, p);
        RectF nube3 = new RectF(x1n3, 100, x2n3, 200);
        c.drawOval(nube3, p);
        //pasto
        p.setColor(Color.GREEN);
        RectF pasto = new RectF(0, 560, 1184, 624);
        c.drawRect(pasto, p);
        //arbol
        p.setColor(Color.argb(255,97,46,7));
        RectF tronco = new RectF(290, 565, 320, 430);
        c.drawRect(tronco, p);

        p.setColor(Color.GREEN);
        RectF hoja1 = new RectF(200, 450, 320, 350);
        c.drawOval(hoja1, p);
        RectF hoja2 = new RectF(240, 430, 390, 290);
        c.drawOval(hoja2, p);
        RectF hoja3 = new RectF(300, 450, 420, 350);
        c.drawOval(hoja3, p);
        //casa
        p.setColor(Color.argb(255,194,161,83));
        c.drawRect(590, 565, 850, 460, p);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(2);
        c.drawRect(590, 565, 850, 460,p);

        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);
        c.drawLine(590,460,720,400,p);
        c.drawLine(720,400,850,460,p);
        c.drawLine(590,460,850,460,p);
        c.drawLine(595,455,845,455,p);
        c.drawLine(605,450,835,450,p);
        c.drawLine(610,445,830,445,p);
        c.drawLine(625,440,815,440,p);
        c.drawLine(645,430,795,430,p);
        c.drawLine(670,420,770,420,p);
        c.drawLine(695,410,750,410,p);
        //puerta
        p.setColor(Color.argb(255,97,46,7));
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(5);
        c.drawRect(750, 565, 800, 490,p);
        c.drawRect(760, 525, 761, 526,p);
        //ventana
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.argb(255,142,198,215));
        c.drawRect(615, 520, 690, 480,p);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.argb(255,97,46,7));
        c.drawRect(615, 520, 690, 480,p);
        //Hombre de nieve
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.WHITE);
        RectF bola1 = new RectF(1045, 570, 955, 490);
        c.drawOval(bola1, p);
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.STROKE);
        c.drawOval(bola1, p);

        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.WHITE);
        RectF bola2 = new RectF(1040, 500, 960, 430);
        c.drawOval(bola2, p);
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.STROKE);
        c.drawOval(bola2, p);

        c.drawRect(990, 450, 988, 448,p);
        c.drawRect(1010, 450, 1008, 448,p);
        c.drawLine(1020,470,980,470,p);

        c.drawRect(998, 510, 1000, 508,p);
        c.drawRect(998, 520, 1000, 518,p);
        c.drawRect(998, 530, 1000, 528,p);






    }
}
