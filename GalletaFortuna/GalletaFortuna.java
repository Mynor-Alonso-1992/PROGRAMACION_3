import java.util.Scanner;
import java.util.Random;

public class GalletaFortuna implements MensajeProvider {

    private String [] mensajes = {
            "El éxito comienza con un solo paso.",
            "Hoy es un buen día para desafiar tus límites.",
            "Las oportunidades llegan a quienes están preparados.",
            "La constancia vence al talento cuando el talento no trabaja duro.",
            "Cada reto es una oportunidad disfrazada.",
            "Cree en ti, eres capaz de lograrlo.",
            "La disciplina es el puente entre metas y logros.",
            "No esperes el momento perfecto, haz que el momento sea perfecto.",
            "Tu actitud define tu altitud.",
            "Nunca es tarde para reinventarte.",
            "El conocimiento te abre puertas, la acción te lleva a través de ellas.",
            "La grandeza se construye con pequeños hábitos diarios.",
            "El coraje no es la ausencia de miedo, sino la determinación de seguir adelante.",
            "Aprender de los errores es el primer paso hacia el éxito.",
            "La clave está en avanzar, aunque sea un paso a la vez.",
            "Tus sueños están a la distancia de tu esfuerzo.",
            "Lo imposible solo tarda un poco más.",
            "Cada día es una nueva oportunidad para brillar.",
            "El mejor momento para actuar fue ayer, el segundo mejor momento es ahora.",
            "Si quieres resultados diferentes, haz cosas diferentes."
    };

    @Override
    public String obtenerMensajeAleatorio() {
        Random random = new Random();
        return mensajes[random.nextInt(mensajes.length)];
    }
}
