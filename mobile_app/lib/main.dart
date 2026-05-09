import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Students App',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: Text('Mobile App'),
          actions: [IconButton(onPressed: null, icon: Icon(Icons.cloud))],
        ),
        body: Text('Corps'),
        floatingActionButton: FloatingActionButton(
          onPressed: null,
          child: IconButton(onPressed: null, icon: Icon(Icons.add)),
        ),
      ),
      debugShowCheckedModeBanner: false,
    );
  }
}
