def call(String repoUrl){
pipeline {
     agent any
     tools {
         maven 'maven'
     }
     stages {
         stage("Tools initialization") {
             steps {
                 sh 'mvn --version'
                 sh 'java -version'
             }
         }
         stage('Demo New app'){
            steps{
                sh 'cat /etc/passwd'
                echo 'Jenkinns was easy'
            }
         }
         stage("Checkout Code") {
             steps {
                 git branch: 'main',
                        url: "${repoUrl}"
             }
         }
         stage("to-test-maven") {
             steps {
                 sh 'mvn -v'
             }
         }
     }
}

}
  
