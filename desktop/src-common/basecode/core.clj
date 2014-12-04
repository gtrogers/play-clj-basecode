(ns basecode.core
  (:require [play-clj.core :refer :all]
            [play-clj.ui :refer :all]))

(defscreen main-screen
  :on-show
  (fn [screen entities]
    (update! screen :renderer (stage))
    [
     ; some text
     (assoc (label "Hello world!" (color :white)) :x 200) 
     ; a simple shape
     (shape :filled :rect 100 100 50 50 :set-color (color :green)) 
     ])
  
  :on-render
  (fn [screen entities]
    (clear!)
    (render! screen entities)))

(defgame basecode
  :on-create
  (fn [this]
    (set-screen! this main-screen)))
