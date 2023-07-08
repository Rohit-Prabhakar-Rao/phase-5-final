pipeline {
  agent any

  environment {
    gitUsername = 'Rohit-Prabhakar-Rao'
    gitEmail = 'rohitrao1411@gmail.com'
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
          sh 'git add .'
          sh "git config --local user.name '${gitUsername}'"
          sh "git config --local user.email '${gitEmail}'"
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
