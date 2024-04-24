pipeline {
//  agent any

//  Node name agent
//  agent {
//    node { label "workstation" }
//  }

  agent {
    label "terraform"
  }

  environment {
    sample = "google.com"
  }

  stages {
    stage("one") {
      steps {
        echo "one"
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