FROM openjdk

COPY aula.txt app/aula.txt

ADD aula.tar.gz app/aula/

RUN mkdir / aula

CMD ["/app"]

ENTRYPOINT ["ls"]

WORKDIR "/app"

ENV MINHA_APLICACAO=app.jar

COPY $MINHA_APLICACAO /app

EXPOSE 8080