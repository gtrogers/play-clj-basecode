(ns basecode.core
  (:require [play-clj.core :refer :all]
            [play-clj.ui :refer :all]
            [play-clj.g2d :refer :all]
            ))

(defn- update-text [entities]
  (map (fn [e] (if (:text e) (do (label! e :set-text "key pressed") (prn e) e) e)) entities))

(defn- text-box! [text width]
  (let [l (label text (color :white))]
   (doto l 
     (label! :set-wrap true)
     (label! :set-width width)) 
    ))

(defscreen main-screen
  :on-show
  (fn [screen entities]
    (update! screen :renderer (stage))
    [
     ; some text
     (assoc (text-box! "This is some really long text becasue I want to see if word wrapping works" 100) :x 300 :y 200 :text true) 
     ; a simple shape
     (shape :filled :rect 100 100 50 50 :set-color (color :green)) 
     ; a texture
     (assoc (texture "test_square.png") :x 400 :y 100) 
     ])
  
  :on-render
  (fn [screen entities]
    (clear!)
    (render! screen entities))

  :on-key-down 
  (fn [screen entities]
    (when (key-pressed? :r) (update-text entities)))) 

(defgame basecode
  :on-create
  (fn [this]
    (set-screen! this main-screen)))

