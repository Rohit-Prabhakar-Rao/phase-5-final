pipeline {
  agent any

  environment {
    gitUsername = 'Rohit-Prabhakar-Rao'
    gitEmail = 'rohitrao1411@gmail.com'
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
        script {
          withCredentials([usernamePassword(credentialsId: gitCredentials, usernameVariable: 'Rohit-Prabhakar-Rao', passwordVariable: 'Rohitr@o14')]) {
            sh "git config user.name '${gitUsername}'"
            sh "git config user.email '${gitEmail}'"
            sh 'git add .'
            sh 'git commit -m "Automated build and run"'
            sh 'git push origin master'
          }
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
