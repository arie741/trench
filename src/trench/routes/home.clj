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

;;Helper funcitons
(defn fv [v m]
  (if (find m v) 
    (find m v)
    0))
;;Templates

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

;whole sequence re rk rf rw rn rg ra rl rp ri rt rv rx rs rb ro rr rd rc rz

(defsnippet resultpage "trench/views/result.html"
  [:div#content]
  [re rk rf rw rn rg ra rl rp ri rt rv rx rs rb ro rr rd rc rz]
  [:div#re] (html/content (str "Pengendalian emosi: " re))
  [:div#rp] (html/content (str "Mengendalikan ornag lain: " rp))
  [:div#rg] (html/content (str "Peranan sebagai pekerja keras: " rg)))

(defroutes app-routes
  (GET "/" [] 
    (page loginpage))
  (POST "/login-action" request
    (str request))
  (GET "/home" [] 
    (page homepage))
  (GET "/session" [] 
    (page sessionpage))
  (GET "/querydb" []
    (apply str db/contentdb))
  (GET "/session/:canswers" [canswers]
    (let [resu (db/checkans canswers)
          sorted-res (frequencies resu)]
      (page #(resultpage 
                (fv "E" sorted-res) 
                (fv "K" sorted-res)
                (fv "F" sorted-res) 
                (fv "W" sorted-res) 
                (fv "N" sorted-res) 
                (fv "G" sorted-res) 
                (fv "A" sorted-res) 
                (fv "L" sorted-res) 
                (fv "P" sorted-res) 
                (fv "I" sorted-res) 
                (fv "T" sorted-res) 
                (fv "V" sorted-res) 
                (fv "X" sorted-res) 
                (fv "S" sorted-res) 
                (fv "B" sorted-res) 
                (fv "O" sorted-res) 
                (fv "R" sorted-res) 
                (fv "D" sorted-res)  
                (fv "C" sorted-res) 
                (fv "Z" sorted-res)))))
  (route/not-found "Not Found"))