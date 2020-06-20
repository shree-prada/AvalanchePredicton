import pickle
from sklearn.preprocessing import StandardScaler
model=pickle.load(open('fore.pkl','rb'))
scaler=pickle.load(open('scaler2.pkl','rb'))


from flask import Flask,render_template,request,url_for
app=Flask(__name__,static_url_path='/static')
@app.route('/')
def helloworld():
    return render_template("first.html")
@app.route('/index')
def index():
    return render_template('index.html')

@app.route('/login' ,methods=['POST'])
def admin():
    p=request.form["rh"]
    q=request.form["sp"]
    s=request.form["s"]
    r=request.form["sd"]
    a=request.form["at"]
    b=request.form["wd"]
    if(s=='High'):
        s1,s2,s3=1,0,0
    if(s=='Low'):
        s1,s2,s3=0,1,0
    if(s=='Medium'):
        s1,s2,s3=0,0,1
   
    
    t=[[int(s1),int(s2),int(s3),float(p),int(q),int(r),int(a),int(b)]]
    y=model.predict((t))
    if(y[0]==0):
        str="High"
    if(y[0]==1):
        str="Low"
    if(y[0]==2):
        str="Medium"
    return render_template('index.html',y="Avalanche is "+str)
@app.route('/user')
def hiuser():
    return "hi, welcome"
if __name__=='__main__':
    app.run(debug=True)



