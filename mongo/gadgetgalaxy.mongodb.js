
//Challenge - GadgetGalaxy
use('GadgetGalaxy');

const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.createCollection('products', {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["name", "price", "inStock"],
		  // additionalProperties:false, // in tandem with validationAction, this will disallow dynamic fields other than what we specify here, i.e. locking our schema
         properties: {
            name: {
               bsonType: "string",
               description: "must be a string and is required"
            },
            price: {
               bsonType: "double",
               description: "must be a double and is required. "
            },
            inStock: {
               bsonType: "bool",
               description: "must be a T/F value and is required"
            },
            specs: {
               bsonType: "object",
               description: "must be an object with product specifications",
               properties: {
                  brand: {
                     bsonType: "string",
                     description: "must be a string"
                  }
      }
   }
         }
      }
   },
   //validationAction: "error" // Rejects invalid documents. Use "warn" just to log warnings.
});

db.getMongo().getDBs();

use('GadgetGalaxy');
db.products.drop()
db.getCollectionNames();


const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.products.insertMany([
	{ name: 'Mouse', price: 39.99, inStock: true, specs: { brand: "Corsair", weight: "60g" }},
	{ name: 'Monitor', price: 149.99, inStock: true, specs: { brand: "Acer", refreshRate:"144hz" } },
   { name: 'Mechanial Keyboard', price: 78.99, inStock: true, specs: { brand: "Razer", switchType:"Red" }}
]);

const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.products.insertOne( { name: 'Mouse', price: "hi", inStock: true, specs: { brand: "Corsair", weight: "60g" } });

const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.products.updateOne(
	{ name: 'Mouse' },
	{ $set: { category: 'Accessories' } }
);

const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.products.updateOne(
	{ name: 'Mouse' },
	{ $inc: { price: 5 } }
);

/*
Add an array field called tags to that product using $push to add "wireless". Then, use $push again to add "bestseller".
Decide you don't want "wireless" after all, and use $pull to remove it from the tags array.
Find all products priced greater than or equal to a certain amount using $gte.
Find all products made by a specific brand using dot notation (e.g., "specs.brand").
Find products whose category matches one in a list using $in.
*/

const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.products.updateOne(
	{ name: 'Mouse' },
	{ $push: { tags: 'wireless' } },
   { $push: { tags: 'bestseller' } }
);


const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.products.find({price: {$gte:100} });


const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.products.find({ "specs.brand":'Corsair' });

const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.products.find({ name: {$in:['Mouse','Keyboard']} });

/*
Create a second collection named orders.
Insert a document into orders that links a product's _id to an order (e.g., { productId: <ObjectId_from_product>, quantity: 2 }).
Write an aggregation pipeline on the orders collection using $lookup and $unwind to join orders with products.
Use $project to output a clean customer receipt showing:
The product name ($product.name)
The ordered quantity (quantity)
Hiding the _id field.
*/
const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.orders.drop()


use('GadgetGalaxy');

const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.createCollection('orders');

ProductsDB.orders.insertOne( { productId: ObjectId('6ab1935e6fd287d9e071a0f3'), quantity: "2"});

const ProductsDB = db.getSiblingDB('GadgetGalaxy');
ProductsDB.orders.aggregate([
   {
      $lookup: {
         from: 'products',
         localField: 'productId',
         foreignField: '_id',
         as: 'product'
      }
   },
   { $unwind: '$product' },
   {
      $project: {
         _id: 0,
         name: '$product.name',
         quantity: 1
      }
   }
]);