package Fichas.Ficha2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Ex3 {

        private LocalDate datas[];
        private int tam;

        public Ex3(int n) {
             this.datas = new LocalDate[n];
             this.tam = 0;
        }

        public Ex3() {
        //usar o this com () é equivalente a chamar o construtor com algum argumento.
        //Seria o mesmo que ListaDeLocalDates (10);
            this(10);
        }

        //(a)
        public void insereData() {
            if (tam < datas.length)
                this.datas[tam++] = LocalDate.of(2022, tam, 24);
        }


        //(b)
        public LocalDate dataMaisProxima (LocalDate data) {
            int min = 10000, aux = 0;
            LocalDate res = datas[0];
            for (int i = 0; i < tam; i++) {
                Period espacoTempo = Period.between(data, datas[i]);
                if (Math.abs(espacoTempo.getDays()) < min) {
                    res = datas[i];
                    min = Math.abs(espacoTempo.getDays());
                }
            }
            return res;
        }

        //(c)
        public String toString () {

            return "Datas Disponíveis: (" + Arrays.toString(this.datas) + ")";
        }
}
