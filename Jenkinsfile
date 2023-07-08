pipeline {
  agent any
environment{
   def gitUsername = 'Rohit-Prabhakar-Rao'
    def gitEmail = 'rohitrao1411@gmail.com'
  
}
  stages {
    stage('Clone repository') {
      steps {
        git branch: 'master', url: 'https://github.com/Rohit-Prabhakar-Rao/phase-5-final.git'
      }
    }

   
    stage('Build and run application') {
  steps {
    sh 'java -jar Springbootapp-0.0.1-SNAPSHOT.jar & echo $! > ./pid.file &'
  }
}


    stage('Stop application') {
  steps {
    script {
      
      sh 'kill -9 $(cat ./pid.file)'
      
    }
  }
}


    stage('Push changes to GitHub') {
      steps {
        script {
          // def gitUsername = 'Rohit-Prabhakar-Rao'
          // def gitEmail = 'rohitrao1411@gmail.com'

          sh 'git config --global user.name "${gitUsername}"'
          // git config --global user.email "you@example.com"
          sh 'git config --global user.email "${gitEmail}"'

          sh 'git add .'
          sh 'git commit -m "Automated build and run"'
          sh 'git push origin master'
        }
      }
    }
  
  }
  post {
    always {
      sh 'rm -f app.pid'
    }
  }
}

