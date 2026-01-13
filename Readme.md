Fase 0 — Fundamentos obrigatórios

A Fase 0 tem como objetivo alinhar a base técnica necessária para que o estudo de Spring Boot e desenvolvimento de APIs REST não fique superficial nem confuso. Esses fundamentos não existem para serem dominados academicamente, mas para garantir que você compreenda o que está acontecendo quando o framework entra em cena. Um desenvolvedor backend profissional não depende cegamente do framework; ele entende o que está por baixo o suficiente para não cometer erros conceituais.

No que diz respeito ao Java moderno (Java 17 ou superior), o foco está na escrita de código mais claro, conciso e previsível. No dia a dia do backend, você lidará constantemente com coleções de dados vindas do banco, transformando entidades em DTOs, filtrando informações, agrupando resultados e validando regras simples. Para isso, o uso prático de streams é essencial, especialmente operações como map, filter, collect e métodos de verificação como anyMatch e allMatch. Não é objetivo dessa fase estudar streams avançados, paralelismo ou construções excessivamente complexas, pois isso costuma gerar código ilegível e difícil de manter. O Optional entra como uma ferramenta para evitar NullPointerException e deixar explícita a possibilidade de ausência de valor, sendo utilizado principalmente como tipo de retorno de métodos, especialmente em repositórios. Seu uso não deve se espalhar para atributos de classe ou parâmetros de métodos, pois isso mais atrapalha do que ajuda. Já os records surgem como uma forma moderna e eficiente de representar DTOs, requests e responses, reduzindo boilerplate e incentivando imutabilidade, algo altamente desejável em APIs.

O estudo de Java nesta fase deve evitar completamente detalhes internos da JVM, garbage collection, bytecode ou ajustes finos de performance. O objetivo é ler e escrever código Java moderno com conforto, entender mensagens de erro e saber refatorar código antigo para um estilo mais atual e limpo. Exercícios recomendados incluem transformar listas de entidades em DTOs usando streams, substituir verificações manuais de null por Optional quando fizer sentido e reescrever classes simples de transporte de dados como records.

Em relação ao Git, o foco é encará-lo como uma ferramenta de trabalho colaborativo e não apenas como um backup de código. Mesmo estudando sozinho, você deve se habituar a trabalhar com branches, commits pequenos e bem descritos e merges conscientes. Um commit profissional resolve um único problema e deixa claro o que foi feito por meio de mensagens objetivas, como a criação de uma funcionalidade ou a correção de um erro específico. Não é necessário estudar rebase interativo avançado, funcionamento interno do Git ou submodules neste momento. O essencial é saber criar um fluxo mínimo realista, ler diffs com tranquilidade e resolver conflitos simples quando eles surgirem. A prática ideal envolve criar um repositório exclusivo para estudos, desenvolver funcionalidades em branches separadas e até simular pull requests, mesmo que localmente.

O terceiro pilar da Fase 0 é o entendimento de HTTP, que é a base invisível de qualquer API REST. Antes mesmo de Spring Boot, é fundamental compreender o significado dos verbos HTTP e sua relação com operações sobre recursos, bem como o papel dos principais status codes. No dia a dia, você utilizará constantemente GET, POST, PUT e DELETE, além de interpretar corretamente respostas como 200, 201, 204, 400, 401, 403, 404 e 500. Um erro comum de iniciantes é tratar HTTP de forma superficial, o que resulta em APIs confusas e difíceis de consumir. Aqui, o estudo deve ser estritamente prático, focado na montagem correta de requisições, no entendimento das respostas e na interpretação consciente de erros. Não é necessário aprofundar-se em protocolos de rede, TCP/IP, versões avançadas do HTTP ou headers pouco utilizados.

Para consolidar esses fundamentos, a Fase 0 propõe um mini-projeto simples: a criação de uma API extremamente básica em Java, sem o uso de Spring, contendo ao menos um endpoint que retorne um JSON. Esse projeto existe apenas para que você entenda o caminho completo de uma requisição, desde a chamada HTTP até a resposta, sem que o framework abstraia tudo. O uso correto de Git faz parte do exercício, assim como a escolha consciente de verbos e status HTTP.

Você pode considerar a Fase 0 concluída quando conseguir explicar com suas próprias palavras o que é uma API REST, quando não sentir insegurança ao lidar com requisições HTTP, quando conseguir ler e escrever Java moderno sem estranheza e quando o uso do Git deixar de ser algo mecânico e passar a ser natural. Com essa base sólida, o estudo da Fase 1 — Spring Boot essencial — deixa de ser um salto no escuro e passa a ser uma progressão lógica e consciente.




Comandos:

javac src/Main.java
java -cp src Main

Testando Api:

No navegador:
http://localhost:8080/hello
