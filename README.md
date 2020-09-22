# Representa-o-Externa-de-Dados
```
Um serviço de gerenciamento de notas de alunos usando o formato JSON. 
```

## Bibliotecas utilizadas

### Java

- com.google.gson
- java.nio.charset.Charset
- java.nio.charset.StandardCharsets
- java.net
- java.io
- java.sql

### Python
- socket 
- port sys
- jsonpickle

## Instalação de dependências

### Clonar e acessar repositório
```
https://github.com/alanrps/RepresentacaoExternaDeDados.git
cd RepresentacaoExternaDeDados
```

### Obter Bibliotecas Java
```
mkdir javacode/lib
cd javacode/lib
wget https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.32.3.2/sqlite-jdbc-3.32.3.2.jar
wget https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.6/gson-2.8.6.jar
```

### Obter Bibliotecas Python
```
pip instalar jsonpickle
```

## Compilação e execução

### Compilar e executar o servidor no diretório javacode
```
javac -cp ":lib/*": *.java -Xlint
java -cp ":lib/*": ServidorTcpJson 
```

### Executar o cliente no diretório pythoncode
```
python3 clientJson.py
```

## Exemplo de uso (Listar alunos em uma disciplina)

### No cliente, digite o codigo da operação
```
listAlunos
```

### E por fim, insira as informações da disciplina. O resultado sairá como:
```
RA: 111111
Nome: Fulano
Periodo: 6
Nota: 10.0
Faltas: 5
--------------------

RA: 222222
Nome: Ciclano
Periodo: 7
Nota: 0.0
Faltas: 1
--------------------
```


