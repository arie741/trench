(ns trench.routes.home
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [net.cgrand.enlive-html :refer [deftemplate defsnippet] :as html]
    [hiccup.core :as hc]
    [noir.session :as session]
    [noir.io :as io]
    [noir.response :as resp]
    [clojure.java.io :as cio]))

(deftemplate page "trench/views/layout.html"
  [content]
  [:content] (html/content (content)))

(defsnippet homepage "trench/views/index.html" 
  [:div#content]
  [])

(defsnippet loginpage "trench/views/login.html" 
  [:div#content]
  [])

(defroutes app-routes
  (GET "/" [] (page loginpage))
  (GET "/home" [] (page homepage))
  (route/not-found "Not Found"))