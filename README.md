# mobiquity-challenge

For this challenge I use knapsack algorithm for otimize packs passed as parameter. 

For better approach of API using case. 

I applied a Abstract Factory Pattern in this classes: 

PackerServiceFactory <br>
PackerServiceFactoryImpl  <br>

![Diagram Class](https://github.com/edu1006/mobiquity-challenge/blob/main/Untitled%20Diagram.drawio)
<br> 

I am using this approach trying to fallow Open Closed Principal from SOLID, bringing more flexiblity for changes without break my users that are using my API. 


For build this project use: 

mvn clean install

![image](https://user-images.githubusercontent.com/15005891/118427438-90313300-b6a3-11eb-8fa1-32d8acb412cf.png)


Test coverage: 

![image](https://user-images.githubusercontent.com/15005891/118427526-d090b100-b6a3-11eb-958a-0f10861c93ca.png)


