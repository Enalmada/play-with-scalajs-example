# Play Framework with Scala.js [![Build Status](https://travis-ci.org/Enalmada/play-with-scalajs-example.svg?branch=master)](https://travis-ci.org/Enalmada/play-with-scalajs-example) [![Join the chat at https://gitter.im/Enalmada/play-with-scalajs-example](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Enalmada/play-with-scalajs-example?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge) 
This example extends the amazing work done by vmunier:
- refactored to focus on the main app as root project with a javascript client module (see vmunier project for complete shared code ex)
- using LAB async javascript loader which is best practice for optimal performance
- using digest asset versioning which I feel is necessary for production apps

See [play-beanstalk(https://github.com/Enalmada/play-beanstalk)] to learn how to deploy this into EC2. (Or look at the origin vumnier project for Heroku)