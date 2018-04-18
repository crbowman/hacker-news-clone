(ns hacker-news-clone.core
  (:use [compojure.core :as c]
        [ring.util.response]
        [ring.middleware.content-type]
        [ring.middleware.params :refer [wrap-params]]
        [ring.middleware.json :refer [wrap-json-body wrap-json-response]])
  (:require [clojure.tools.logging :refer [info error]]
            [clojure.string :as string]
            [compojure.route :as route]
            [compojure.handler :as handler])
  (:gen-class :main true))

(defn wrap-fail-safe [handler]
  "Wraps a safe failure response"
  (fn [req]
    (try
      (handler req)
      (catch Exception e
        (error e)
        {:status 422
         :body {:errors {:body ["Server error due to wrong user input."]}}}))))

(defn wrap-access-log [handler]
  "Wraps the server log for each request received."
  (fn [req]
    (info "==> " (req :uri))
    (let [response (handler req)]
      (info "<== " (req :uri) "[" (response :status) "]")
      response)))

(defn wrap-middlewares [routes]
  "Wraps routes with all common middlewares."
  (-> routes
      wrap-fail-safe
      wrap-params
      wrap-json-response
      wrap-access-log
      (wrap-json-body {:kewords? true})))

(c/defroutes public-routes
  (c/GET "/resource-status" [] "OK")
  (c/GET "/health" [] "Service healthy!"))

(def app
  (wrap-middlewares public-routes))
