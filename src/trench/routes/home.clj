(ns trench.routes.home
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [net.cgrand.enlive-html :refer [deftemplate defsnippet] :as html]
    [hiccup.core :as hc]
    [noir.session :as session]
    [noir.io :as io]
    [noir.response :as resp]
    [clojure.java.io :as cio]
    [trench.routes.db :as db]))

(deftemplate page "trench/views/layout.html"
  [content]
  [:content] (html/content (content)))

(defsnippet homepage "trench/views/index.html" 
  [:div#content]
  [])

(defsnippet loginpage "trench/views/login.html" 
  [:div#content]
  [])

(defsnippet qsnippet "trench/views/qsnippet.html"
  [:div.questionrow]
  [qid qs1 qs2 & qclass]
  [:div.questionrow] (html/set-attr 
                            :id (str "q" qid) 
                            :class (str "row questionrow " (apply str qclass)))
  [:button.ans-1] (html/set-attr
                            :onclick (str "next(" qid ",1)"))
  [:button.ans-2] (html/set-attr
                            :onclick (str "next(" qid ",2)"))
  [:h4.qs1] (html/content (str qs1))
  [:h4.qs2] (html/content (str qs2)))

(defsnippet sessionpage "trench/views/session.html"
  [:div#content]
  []
  [:div#qtemplate] (html/content (map #(qsnippet (:qnumber %) (:question1 %) (:question2 %) "hidden") db/contentdb))
  [:div#q1] (html/remove-class "hidden"))

(defroutes app-routes
  (GET "/" [] 
    (page loginpage))
  (POST "/login-action" request
    (str request))
  (GET "/home" [] 
    (page homepage))
  (GET "/session" [] 
    (page sessionpage))
  (GET "/query" []
    (apply str db/contentdb))
  (route/not-found "Not Found"))