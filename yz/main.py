from fastapi import FastAPI
from pydantic import BaseModel
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
os.environ['TF_ENABLE_ONEDNN_OPTS'] = '0'
import tensorflow as tf
import joblib
import numpy as np

app=FastAPI()
model=tf.keras.models.load_model("hakemAnalizi.h5",compile=False)
scaler=joblib.load("hakemScaler.pkl")

class HakemPerformans(BaseModel):
    dogru:int
    yanlis:int
    bos:int
    performans:int

@app.post("/tahmin")
def tahmin_et(veri: HakemPerformans):
    bilgiler=np.array([[veri.dogru, veri.yanlis, veri.bos, veri.performans]])
    bilgiler=scaler.transform(bilgiler)
    tahmin=model.predict(bilgiler)
    sonuc=int(tahmin[0][0])
    return {"tahmin": sonuc}