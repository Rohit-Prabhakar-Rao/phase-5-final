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
        // git credentialsId: 'sshkey', url: 'git@github.com:Rohit-Prabhakar-Rao/phase-5-final.git'
        // sh 'git clone https://github.com/Rohit-Prabhakar-Rao/phase-5-final.git'
        // git branch: 'master', url: 'https://github.com/Rohit-Prabhakar-Rao/phase-5-final-project.git'
        git 'https://github.com/Rohit-Prabhakar-Rao/phase-5-final.git'


      }
    }


    stage('Build and run application') {
      steps {
        sh 'java -jar Springbootapp-0.0.1-SNAPSHOT.jar & echo $! > ./pid.file &'
        // sh 'java -jar Springbootapp-0.0.1-SNAPSHOT.jar'
        // sleep(time: 1, unit: 'MINUTES')
        // sh 'echo $! > ./pid.file'
      
      }
    }
      stage('Buffer Time') {
            steps {
                // Add a delay of 5 minutes (adjust as needed)
                sleep(time: 1, unit: 'MINUTES')
            }
        }

    stage('Stop application') {
      steps {
        script {
          sh 'kill -9 $(cat ./pid.file)'
        }
      }
    }
    stage("Push to Git Repository") {
            steps {
                withCredentials([gitUsernamePassword(credentialsId: 'githubCred', gitToolName: 'Default')]) {
                    sh "git push -u origin master"
                }
            }
        }
  
  }


  post {
    always {
      sh 'rm -f pid.file'
    }
  }
}
