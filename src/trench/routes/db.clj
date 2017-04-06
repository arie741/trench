(ns trench.routes.db
  (:require [clj-postgresql.core :as pg]
            [clojure.java.jdbc :as jdbc]
            [clojurewerkz.scrypt.core :as sc]))

(def db (pg/pool :host "localhost:5432"
                 :user "trench"
                 :dbname "trench"
                 :password "admin2016"))

;encrypt-value 16384 8 1

(def data (sc/encrypt "asdsada" 16384 8 1))

;db query
(def contentdb 
	(jdbc/query db ["SELECT * FROM CONTENT"]))