package Fichas.Ficha4.Ex1;

public class TesteStack {

        public static void main (String [] args) {
            Stack st = new Stack();

            //a)
            st.push(".");
            st.push("Paulo");
            st.push("o");
            st.push("sou");
            st.push("eu");
            st.push("Olá");
            System.out.println("a) " + st.toString());

            //b)
            String str = st.top();
            System.out.println("b) " + str);

            //c)
            st.pop();
            st.pop();
            System.out.println("c) " + st.toString());

            //d)
            boolean b = st.empty();
            System.out.println("d) " + st.empty());

            //e)
            int len = st.length();
            System.out.println("e) " + len);

        }
}
