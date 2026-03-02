package com.example.zegarszachowy;

import android.os.CountDownTimer;
import android.widget.Button;

public class Gracz {
    private int ileSekund = 180;
    private boolean czyAktywny;
    private CountDownTimer countDownTimer;
    private Button button; // wiocha bo nie powinno się łączyć widoku z działaniem

    public boolean isCzyAktywny() {
        return czyAktywny;
    }

    public void setCzyAktywny(boolean czyAktywny) {
        this.czyAktywny = czyAktywny;
    }

    public Gracz(Button button, boolean czyAktywny) {
        this.button = button;
        this.czyAktywny = czyAktywny;
        if(czyAktywny){
            uruchomZegar();
        }else{
            button.setClickable(false);
        }
    }
    private void uruchomZegar(){
        countDownTimer = new CountDownTimer(ileSekund*1000, 1000) {
            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long millisUntilFinished) {
                ileSekund = (int)millisUntilFinished/1000;
                button.setText("" + ileSekund);
            }
        };
        countDownTimer.start();
    }

    private void zatrzymajZegar(){
        countDownTimer.cancel();
    }

    public void odwwrocAktywnosc(){
        czyAktywny = !czyAktywny;
        button.setClickable(false);
        if(czyAktywny){
            uruchomZegar();
        }else{
            zatrzymajZegar();
        }
    }
}
