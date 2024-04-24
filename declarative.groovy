pipeline {
//  agent any

//  Node name agent
  agent {
    node { label "workstation" }
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
}