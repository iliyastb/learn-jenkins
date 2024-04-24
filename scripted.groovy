node("workstation") {
  try {
    stage("one") {
      echo "one"
    }

    stage("two") {
      echo "two"
    }
  } catch (e) {
    stage ("Declarative: post actions") {
      echo "This will run only if failed"
    }
  }
}