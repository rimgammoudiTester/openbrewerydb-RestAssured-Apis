pipline{
agent any
tools
{
 maven 'maven'
}
stages{
 stage('Build')
 {
 steps{
 echo 'The build is done succesfully'
 sh 'mvn clean'

 }}

 stage('Test')
  {
  steps{
       echo 'Tests breweries are running'
       sh 'mvn test -Dsurefire.suiteXmlFiles=suites/suite.xml'


  }}
  stage('Deploy')
    {
    steps{
     echo 'Runing in the server AWS'
    }
 }}


}
post{
always{
echo 'end of pipline!'
}
failure{
echo 'failure somthing went wrong!'
}
}


}