# Izicap Homework Backend Engineering - Internshipn docker

## how  to  work  with  this  project
* Clone the project
* build the izicap chatgpt docker image  using command :  docker build . -t izicap
* build the docker container using command  : docker-compose build
* start the docker container using command  : docker-compose up -d

## Step how this  project was built

* Create an Account openai.com
* Create API key at https://beta.openai.com/account/api-keys
* Store the key in application.properties file in cloned project
* manage to send an input (Question) and return an output (Response)
* store the result in  a file .csv (/chatgpt/data/response.csv)
* Create a  view from theamleaf using bootstrap for design and adding a Form Post to send the  resquest and adding the response to a text
* For chatting with izicap ChatGPT: http://localhost:8888/


# Additional information (FROM Chatgpt)


### ChatGPTRequest

This class represents a ChatGPT request object, which contains a single field "question" that holds the question/prompt to be sent to the ChatGPT API. The class also includes getter and setter methods for the question field, as well as a constructor to create a ChatGPTRequest object with a specified question. This class can be used to easily create and manage ChatGPT requests in your application.

### ChatGPTResponse

This class defines a simple data structure to hold the information of a conversation between a user and the OpenAI ChatGPT API. It contains two fields, one for the question asked by the user and another for the answer provided by the API. The class also provides getters and setters for both fields to access the data.

### CompletionRequest

This is the CompletionRequest class, it's used to make a request to the OpenAI API to generate a response using GPT-3. It contains the fields "model", "prompt", "temperature" and "max_tokens", which are used as parameters in the API request. The defaultWith method is used to set default values for these fields when a new instance of the class is created, making it easier to create requests with commonly used values.

### CompletionResponse

The "CompletionResponse" class is a record that has two fields, "usage" and "choices", that are used to store information about the completion of a prompt using the OpenAI API. The class also has a method "firstAnswer()" which returns the first answer from the choices list if it's present, otherwise it returns an empty Optional. The "Usage" and "Choice" records are nested within the "CompletionResponse" record and store additional information about the completion response.

### OpenAiApiClient

This is a Java component class for making API requests to the OpenAI platform. It utilizes the HttpClient library to make a post request to the desired OpenAI service endpoint, such as the GPT-3 API. The class uses the @Value annotation to inject the API key for the OpenAI platform from a properties file, and also uses an enumeration to select the appropriate service endpoint URI, This allows for easy addition of new OpenAI APIs in the future.

### ChatGptController

This is a Spring Boot application that allows users to communicate with OpenAI's GPT-3 API through a web interface. The application accepts user input through a form and sends the input to the GPT-3 API to generate a response. The response, along with the user's input, is then displayed on the web page. Additionally, the application also writes the user's input and the corresponding response to a CSV file. The CSV file is stored in a volume, which allows for the data to persist even if the container is deleted. This application uses the OpenAI API client library to communicate with the API and Jackson for JSON serialization and deserialization.


## VIEW :

![](src/main/resources/pic/izicap.png)

## Project structure
![](src/main/resources/pic/structure.png)

## Docker:
![](src/main/resources/pic/docker.png)
### Image
![](src/main/resources/pic/image d.png)
 
#   I Z I C A P _ c h a t G p t  
 