pipeline {
//  agent any

//  agent {
//    node { label "workstation" }
//  }

  agent {
    label "terraform"
  }

  environment {
    SAMPLE = "google.com"
    SSH = credentials("ssh")
  }

  stages {
    stage("one") {
      steps {
        echo "one"
        sh "env"
      }
    }

    stage("two") {
      steps {
        echo "two"
      }
    }
  }

  post {
    always {
      echo 'Hello again!'
    }
  }
}