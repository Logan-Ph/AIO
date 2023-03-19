import tensorflow as tf
from keras.preprocessing.image import ImageDataGenerator
import numpy as np
from keras.preprocessing import image

#-------------------------Data Preprocessing-------------------------
# image agumentation to avoid overfitting
# rescale is to normalize the data bc the data is in range 0-255 -> normalize it to 0 ->1
train_datagen = ImageDataGenerator(
    rescale = 1./255,
    shear_range = 0.2,
    zoom_range = 0.2,
    horizontal_flip = True
)

#preprocessing the training set
#target size is the size of each image
#bath size is the number of image in 1 batch which is passes into an epoch
training_set = train_datagen.flow_from_directory(
    "C:\\Users\\phamp\\code\\github\\code\\Section 40 - Convolutional Neural Networks (CNN)\\dataset\\training_set",
    target_size = (64,64),
    batch_size = 32,
    class_mode='binary'

)
#preprocessing the testing set
test_datagen = ImageDataGenerator(rescale = 1./255)
test_set = test_datagen.flow_from_directory(
    "Section 40 - Convolutional Neural Networks (CNN)\\dataset\\test_set",
    target_size = (64,64),
    batch_size = 32,
    class_mode = 'binary'
)


#-------------------------Building CNN-------------------------
cnn = tf.keras.models.Sequential()

#"filter" is the feature detectors
#"kernel_size" is the demension of the feature detectors
#"input_shape" is the demension of the input data
cnn.add(tf.keras.layers.Conv2D(filters=32,kernel_size=3, activation='relu',input_shape=[64,64,3])) #convolution

#pooling
#"pool_size" is the size of the pooling features like the one in the Conv this is 2x2
#"strides" is the step to move to another pixels
cnn.add(tf.keras.layers.MaxPool2D(pool_size=2,strides=2))

#second convolution layer
cnn.add(tf.keras.layers.Conv2D(filters=32,kernel_size=3, activation='relu')) #convolution
cnn.add(tf.keras.layers.MaxPool2D(pool_size=2,strides=2))

#-------------------------Flattening-------------------------
cnn.add(tf.keras.layers.Flatten())

#-------------------------Full connection-------------------------
cnn.add(tf.keras.layers.Dense(units=128,activation="relu"))
cnn.add(tf.keras.layers.Dense(units=1,activation="sigmoid"))

#-------------------------Training the CNN-------------------------
#compile the CNN
cnn.compile(optimizer="adam",loss='binary_crossentropy',metrics = ['accuracy'])

#we have "validation_data" bc we want to evaluate the model while training and this is different from the ANN model
cnn.fit(x=training_set, validation_data = test_set, epochs=15 )

#-------------------------Making the single-prediction-------------------------
test_image = tf.keras.utils.load_img("Section 40 - Convolutional Neural Networks (CNN)\\dataset\\single_prediction\\cat_or_dog_1.jpg", target_size = (64,64))

#change the format of the image to the 2D array
test_image = tf.keras.utils.img_to_array(test_image)

#add an extra demension 
test_image = np.expand_dims(test_image,axis = 0)

result = cnn.predict(test_image/255.)

#get the class indices
training_set.class_indices
if result[0][0] >= 0.5:
    prediction = 'dog'
else:
    prediction = "cat"

print(prediction)


