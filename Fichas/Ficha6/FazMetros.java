package Fichas.Ficha6;

/*
                                    // FASE 3 //

1. Desenvolva a interface FazMetros, que deverá ser implementada por estes
tipos de actividades. Esta interface deverá garantir as funcionalidades a
seguir descritas:
            •  definir o total de pontos a atribuir por cada metro
            • obter o valor de pontos que se está a atribuir por cada metro
            • obter o total de pontos que uma determinada actividade originou.

 */

public interface FazMetros {

    public void setPontosMetro(int pontos);
    public int getPontosMetro();
    public double pontos();

    // quem implementa a interface, terá de colocar estes métodos.
}
