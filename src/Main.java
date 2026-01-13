import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/hello", new HelloHandler());

        server.setExecutor(null); // executor padrão
        server.start();

        System.out.println("Servidor iniciado em http://localhost:8080/hello");
    }

    static class HelloHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            List<RecordExample> minhaListaDeRecords = List.of(
                    new RecordExample("Piêtro", 27),
                    new RecordExample("Carol", 31),
                    new RecordExample("Valadão", 28));

            /* FILTER */

            // String response = minhaListaDeRecords.stream()
            // .filter(r -> r.idade() > 30)
            // .map(r -> """
            // {
            // "nome": "%s",
            // "idade": %d
            // }""".formatted(r.nome(), r.idade()))
            // .collect(Collectors.joining(",", "[", "]"));

            /* MAP */

            // String response = minhaListaDeRecords.stream()
            // .map(r -> {
            // String msg = (r.idade() > 30) ? "Esse tem mais de 30 anos" : "Esse não tem
            // mais de 30 anos";
            // return """
            // {
            // "nome": "%s",
            // "mensagem": "%s"
            // }""".formatted(r.nome(), msg);
            // })
            // .collect(Collectors.joining(",", "[", "]"));

            /* MAIS TREINO FILTER MAP E COLLECT */

            // List<AnotherRecordExample> anotherListOfRecords = List.of(
            // new AnotherRecordExample(150, null, "GESTOR"),
            // new AnotherRecordExample(50, "awsdewdsaweddadsa", "ADMIN"),
            // new AnotherRecordExample(340, "dssadawdwadfdfaad", "GESTOR"));

            // String response = anotherListOfRecords.stream()
            // .map(r -> {

            // boolean temAssinatura = r.assinatura() != null && !r.assinatura().isEmpty();

            // boolean ehEspecial = r.money() > 100
            // && temAssinatura
            // && "GESTOR".equals(r.role());

            // String msg = ehEspecial ? "Especial." : "Não é especial.";

            // return """
            // {
            // "mensagem": "%s"
            // }
            // """.formatted(msg).trim();
            // })
            // .collect(Collectors.joining(",", "[", "]"));

            /* ANY MATCH */

            // boolean encontreiUmPietro = minhaListaDeRecords.stream().anyMatch(r ->
            // r.nome().equals("Piêtro"));
            // String response = encontreiUmPietro ? """
            // {"msg": "Encontrei"}
            // """ : """
            // {"msg": "Não encontrei"}
            // """;

            /* ALL MATCH */

            // boolean todosTemMaisDe20 = minhaListaDeRecords.stream().allMatch(r ->
            // r.idade() > 20);
            // String response = todosTemMaisDe20 ? """
            // {"msg":"Todos tem mais de 20"}
            // """ : """
            // {"msg":"Todos não tem mais de 20"}
            // """;

            /* TREINO OPTIONAL */
            Optional<RecordExample> usuarioOpt = minhaListaDeRecords.stream()
                    .filter(r -> r.nome().equalsIgnoreCase("Abudjuga"))
                    .findFirst();
            String response = usuarioOpt
                    .map(r -> """
                            { "nome": "%s", "idade": %d }
                            """.formatted(r.nome(), r.idade()))
                    .orElse("""
                            { "erro": "Usuário não encontrado." }
                            """);
            int statusCode = usuarioOpt.isPresent() ? 200 : 404;
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(statusCode, response.getBytes().length);

            // exchange.getResponseHeaders().add("Content-Type", "application/json");
            // exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}
