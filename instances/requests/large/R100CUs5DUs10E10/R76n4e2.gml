graph [
  node [
    id 0
    label "0"
    type 2
    prc 4
  ]
  node [
    id 1
    label "1"
    type 2
    prc 3
  ]
  node [
    id 2
    label "2"
    type 1
    prc 4
    ant 2
    prb 2
    x 24
    y 30
  ]
  node [
    id 3
    label "3"
    type 1
    prc 5
    ant 5
    prb 3
    x 75
    y 47
  ]
  edge [
    source 0
    target 2
    bandwith 364
    delay 431
  ]
  edge [
    source 1
    target 3
    bandwith 659
    delay 100
  ]
]
