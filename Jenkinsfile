pipeline {
  agent any

  stages {
    stage('Clone repository') {
      steps {
        git branch: 'master', url: 'https://github.com/Rohit-Prabhakar-Rao/phase-5-final.git'
      }
    }

    stage('Build and run application') {
      steps {
        sh 'mvn clean package'
        sh 'java -jar target/Springbootapp-0.0.1-SNAPSHOT.jar'
        sh 'ps -ef | grep "java -jar target/Springbootapp-0.0.1-SNAPSHOT.jar" | grep -v grep | awk \'{print $2}\' > app.pid'
        def pid = readFile('app.pid').trim()
      }
    }

    stage('Stop application') {
      steps {
        def pid = readFile('app.pid').trim()
        sh "kill ${pid}"
        sh 'rm -f app.pid'
      }
    }

    stage('Push changes to GitHub') {
      steps {
        script {
          def gitUsername = 'Rohit-Prabhakar-Rao'
          def gitEmail = 'rohitrao1411@gmail.com'

          git config: "user.name '${gitUsername}'"
          git config: "user.email '${gitEmail}'"
          git add: '.'
          git commit: "message: 'Automated build and run'"
          git push: 'origin master'
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
