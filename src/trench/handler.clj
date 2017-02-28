(ns trench.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [trench.routes.home :refer :all]
            [noir.util.middleware :as middleware]
            [noir.session :as session]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.multipart-params :refer [wrap-multipart-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]))

(def app
  (middleware/app-handler
       [app-routes]
       :middleware [wrap-params wrap-multipart-params]
       :ring-defaults (assoc-in site-defaults [:security :anti-forgery] false)))
