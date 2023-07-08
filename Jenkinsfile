pipeline {
  agent any

  environment {
    gitUsername = 'Rohit-Prabhakar-Rao'
    gitEmail = 'rohitrao1411@gmail.com'
    gitPass = 'Rohitr@o14'
    // registryCredential = '30fe054d-46af-47e4-9e75-948aca898243'
    gitCredentials = credentials('30fe054d-46af-47e4-9e75-948aca898243')
    
  }

  stages {
    stage('Clone repository') {
      steps {
        git 'https://github.com/Rohit-Prabhakar-Rao/phase-5-final.git'
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
        withCredentials([
          usernamePassword(
            credentialsId: '30fe054d-46af-47e4-9e75-948aca898243',
            usernameVariable: 'Rohit-Prabhakar-Rao',
            passwordVariable: 'Rohitr@o14'
          )
        ]) {
          sh '''
            git config --global user.name "Rohit-Prabhakar-Rao"
            git config --global user.email "rohitrao1411@gmail.com"
            git add .
            git commit -m "Automated build and run"
            git push origin master
          '''
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
