import org.example.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    private Calculadora calculadora;
    private int a;
    private int b;

    @BeforeEach
    void inicializar(){
        calculadora = new Calculadora();
        a = 5;
        b = 10;
    }

    @Test
    void somarTest(){
        int resultado = calculadora.somar(a, b);

        Assertions.assertEquals(a+b, resultado);
    }

    @Test
    void subtrairTest(){
        int resultado = calculadora.subtrair(a, b);

        Assertions.assertEquals(a-b, resultado);
    }

    @Test
    void multiplicarTest(){
        int resultado = calculadora.multiplicar(a, b);

        Assertions.assertEquals(a*b, resultado);
    }

    @Test
    void dividirTest(){
        int resultado = calculadora.dividir(a, b);

        Assertions.assertEquals(a/b, resultado);
    }

    @Test
    void testeException(){
        try{
            //estamos testando um metodo que deve retornar essa exception
            throw new IllegalArgumentException();

        } catch (Exception e){
            Assertions.assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    void testeExceptionLambda(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //execução do nosso metodo que sera testado
            throw new IllegalArgumentException();
        });
    }

    @Test
    void testeDividirPorZero(){
        try{
            int resultado = calculadora.dividir(5, 0);
            Assertions.fail("Erro na divisão");
        } catch (Exception e){
            Assertions.assertEquals(ArithmeticException. class, e.getClass());
        }
    }

    @Test
    void testeExceptionLambdaDivisao(){
        Assertions.assertThrows(ArithmeticException.class, ()-> {
            int divisao = calculadora.dividir(5, 0);
        });
    }
}
