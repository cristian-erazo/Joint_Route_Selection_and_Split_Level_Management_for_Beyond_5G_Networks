graph [
  node [
    id 0
    label "0"
    type 2
    prc 3
  ]
  node [
    id 1
    label "1"
    type 2
    prc 5
  ]
  node [
    id 2
    label "2"
    type 1
    prc 3
    ant 9
    prb 3
    x 44
    y 87
  ]
  node [
    id 3
    label "3"
    type 1
    prc 4
    ant 10
    prb 2
    x 90
    y 15
  ]
  node [
    id 4
    label "4"
    type 1
    prc 1
    ant 8
    prb 4
    x 88
    y 53
  ]
  edge [
    source 0
    target 3
    bandwith 442
    delay 497
  ]
  edge [
    source 1
    target 2
    bandwith 223
    delay 384
  ]
  edge [
    source 1
    target 4
    bandwith 117
    delay 224
  ]
]
