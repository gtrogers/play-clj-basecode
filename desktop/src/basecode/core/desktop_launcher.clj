(ns basecode.core.desktop-launcher
  (:require [basecode.core :refer :all])
  (:import [com.badlogic.gdx.backends.lwjgl LwjglApplication]
           [org.lwjgl.input Keyboard])
  (:gen-class))

(defn -main
  []
  (LwjglApplication. basecode "basecode" 800 600)
  (Keyboard/enableRepeatEvents true))
